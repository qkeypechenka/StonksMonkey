package edu.njmsd.stonksmonkey.api.controllers.operation;

import edu.njmsd.stonksmonkey.api.dto.ListResponse;
import edu.njmsd.stonksmonkey.api.dto.OperationDto;
import edu.njmsd.stonksmonkey.api.dto.OperationModificationDto;
import edu.njmsd.stonksmonkey.boundaries.mappers.Mapper;
import edu.njmsd.stonksmonkey.domain.exceptions.ModelNotFoundException;
import edu.njmsd.stonksmonkey.domain.exceptions.ValidationException;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

abstract class BaseOperationController {

    private final CrudService<Operation> service;
    private final Mapper<Operation, OperationDto> operationDtoMapper;
    private final Mapper<OperationModificationDto, Operation> operationMapper;

    protected BaseOperationController(
            CrudService<Operation> service,
            Mapper<Operation, OperationDto> operationDtoMapper,
            Mapper<OperationModificationDto, Operation> operationMapper) {
        this.service = service;
        this.operationDtoMapper = operationDtoMapper;
        this.operationMapper = operationMapper;
    }

    @GetMapping
    public ListResponse<OperationDto> getOperations() {
        var items = service.get().stream().map(operationDtoMapper::map).collect(Collectors.toList());
        return new ListResponse<>(items);
    }

    @PostMapping
    public ResponseEntity<OperationDto> createOperation(
            @RequestBody OperationModificationDto modification,
            HttpServletRequest request) throws URISyntaxException {
        try {
            var operation = service.create(operationMapper.map(modification));
            var uri = new URI(request.getRequestURI() + "/" + operation.getId());
            return ResponseEntity.created(uri).body(operationDtoMapper.map(operation));
        } catch (ValidationException exception) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        } catch (ModelNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public OperationDto updateOperation(@PathVariable long id, @RequestBody OperationModificationDto modification) {
        var operation = operationMapper.map(modification);
        operation.setId(id);
        try {
            operation = service.update(operation);
        } catch (ValidationException exception) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        } catch (ModelNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
        return operationDtoMapper.map(operation);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable long id) {
        try {
            service.delete(id);
        } catch (ModelNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}
