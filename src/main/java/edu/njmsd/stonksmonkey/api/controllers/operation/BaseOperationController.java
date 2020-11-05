package edu.njmsd.stonksmonkey.api.controllers.operation;

import edu.njmsd.stonksmonkey.api.dto.ListResponse;
import edu.njmsd.stonksmonkey.api.dto.OperationCategoryDto;
import edu.njmsd.stonksmonkey.api.dto.OperationDto;
import edu.njmsd.stonksmonkey.api.dto.OperationModificationDto;
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

public class BaseOperationController {

    private final CrudService<Operation> service;
    private final CrudRepository<OperationCategory> repository;

    public BaseOperationController(CrudService<Operation> service, CrudRepository<OperationCategory> repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    public ListResponse<OperationDto> getOperations() {
        var items = service.get().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ListResponse<>(items);
    }

    @PostMapping
    public ResponseEntity<OperationDto> createOperation(
            @RequestBody OperationModificationDto modification,
            HttpServletRequest request) throws URISyntaxException {
        var category = repository.findById(modification.getCategoryId());
        var operation = new Operation(0, category, modification.getAmount(), modification.getDate());
        operation = service.create(operation);
        var uri = new URI(request.getRequestURI() + "/" + operation.getId());
        return ResponseEntity.created(uri).body(convertToDto(operation));
    }

    @PutMapping("/{id}")
    public OperationDto updateOperation(@PathVariable long id, @RequestBody OperationModificationDto modification) {
        var category = repository.findById(modification.getCategoryId());
        var operation = new Operation(id, 0, category, modification.getAmount(), modification.getDate());
        operation = service.update(operation);
        return convertToDto(operation);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable long id) {
        service.delete(id);
    }

    private OperationDto convertToDto(Operation operation) {
        var category = new OperationCategoryDto(operation.getCategory().getId(), operation.getCategory().getName());
        return new OperationDto(operation.getId(), category, operation.getAmount(), operation.getDate());
    }
}
