package edu.njmsd.stonksmonkey.api.controllers;

import edu.njmsd.stonksmonkey.api.dto.ListResponse;
import edu.njmsd.stonksmonkey.boundaries.mappers.Mapper;
import edu.njmsd.stonksmonkey.domain.exceptions.ModelNotFoundException;
import edu.njmsd.stonksmonkey.domain.exceptions.ValidationException;
import edu.njmsd.stonksmonkey.domain.models.Identifiable;
import edu.njmsd.stonksmonkey.domain.models.Owned;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import edu.njmsd.stonksmonkey.security.user.IdentifiableUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

public abstract class CrudController<M extends Identifiable & Owned, D, C> {

    private final CrudService<M> service;
    private final Mapper<M, D> dtoMapper;
    private final Mapper<C, M> modelMapper;

    protected CrudController(CrudService<M> service, Mapper<M, D> dtoMapper, Mapper<C, M> modelMapper) {
        this.service = service;
        this.dtoMapper = dtoMapper;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ListResponse<D> get(@AuthenticationPrincipal IdentifiableUser user) {
        var items = service.get(user.getId()).stream().map(dtoMapper::map).collect(Collectors.toList());
        return new ListResponse<>(items);
    }

    @PostMapping
    public ResponseEntity<D> create(
            @AuthenticationPrincipal IdentifiableUser user,
            @RequestBody C modification,
            HttpServletRequest request) throws URISyntaxException {
        try {
            var model = modelMapper.map(modification);
            model.setUserId(user.getId());
            model = service.create(model, user.getId());
            var uri = new URI(request.getRequestURI() + "/" + model.getId());
            return ResponseEntity.created(uri).body(dtoMapper.map(model));
        } catch (ValidationException exception) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public D update(@AuthenticationPrincipal IdentifiableUser user, @PathVariable long id, @RequestBody C modification) {
        var model = modelMapper.map(modification);
        model.setId(id);
        model.setUserId(user.getId());
        try {
            model = service.update(model, user.getId());
        } catch (ValidationException exception) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        }
        return dtoMapper.map(model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal IdentifiableUser user, @PathVariable long id) {
        try {
            service.delete(id, user.getId());
        } catch (ModelNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}