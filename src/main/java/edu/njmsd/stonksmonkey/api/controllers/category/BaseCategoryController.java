package edu.njmsd.stonksmonkey.api.controllers.category;

import edu.njmsd.stonksmonkey.api.dto.ListResponse;
import edu.njmsd.stonksmonkey.api.dto.OperationCategoryDto;
import edu.njmsd.stonksmonkey.api.dto.OperationCategoryModificationDto;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

abstract class BaseCategoryController {

    private final CrudService<OperationCategory> service;

    protected BaseCategoryController(CrudService<OperationCategory> service) {
        this.service = service;
    }

    @GetMapping
    public ListResponse<OperationCategoryDto> getCategories() {
        var items = service.get().stream()
                .map(category -> new OperationCategoryDto(category.getId(), category.getName()))
                .collect(Collectors.toList());
        return new ListResponse<>(items);
    }

    @PostMapping
    public ResponseEntity<OperationCategoryDto> createCategory(
            @RequestBody OperationCategoryModificationDto modification,
            HttpServletRequest request) throws URISyntaxException {
        var category = service.create(new OperationCategory(0, modification.getName()));
        var uri = new URI(request.getRequestURI() + "/" + category.getId());
        var categoryDto = new OperationCategoryDto(category.getId(), category.getName());
        return ResponseEntity.created(uri).body(categoryDto);
    }

    @PutMapping("/{id}")
    public OperationCategoryDto updateCategory(
            @PathVariable long id,
            @RequestBody OperationCategoryModificationDto modification) {
        var category = service.update(new OperationCategory(id, 0, modification.getName()));
        return new OperationCategoryDto(category.getId(), category.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id) {
        service.delete(id);
    }
}
