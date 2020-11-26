package edu.njmsd.stonksmonkey.api.controllers.operation;

import edu.njmsd.stonksmonkey.api.dto.ListResponse;
import edu.njmsd.stonksmonkey.api.dto.OperationDto;
import edu.njmsd.stonksmonkey.api.dto.OperationModificationDto;
import edu.njmsd.stonksmonkey.boundaries.mappers.Mapper;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.repositories.CrudRepository;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

abstract class BaseOperationController {

    private final CrudService<Operation> service;
    private final CrudRepository<OperationCategory> repository;
    private final Mapper<Operation, OperationDto> operationDtoMapper;
    private final Mapper<OperationModificationDto, Operation> operationMapper;

    protected BaseOperationController(
            CrudService<Operation> service,
            CrudRepository<OperationCategory> repository,
            Mapper<Operation, OperationDto> operationDtoMapper,
            Mapper<OperationModificationDto, Operation> operationMapper) {
        this.service = service;
        this.repository = repository;
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
        var operation = operationMapper.map(modification);
        operation.setCategory(repository.findById(modification.getCategoryId()));
        operation = service.create(operation);
        var uri = new URI(request.getRequestURI() + "/" + operation.getId());
        return ResponseEntity.created(uri).body(operationDtoMapper.map(operation));
    }

    @PutMapping("/{id}")
    public OperationDto updateOperation(@PathVariable long id, @RequestBody OperationModificationDto modification) {
        var operation = operationMapper.map(modification);
        operation.setId(id);
        operation.setCategory(repository.findById(modification.getCategoryId()));
        operation = service.update(operation);
        return operationDtoMapper.map(operation);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable long id) {
        service.delete(id);
    }
}
