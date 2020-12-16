package edu.njmsd.stonksmonkey.api.controllers.category;

import edu.njmsd.stonksmonkey.api.dto.ListResponse;
import edu.njmsd.stonksmonkey.api.dto.OperationCategoryDto;
import edu.njmsd.stonksmonkey.api.dto.OperationCategoryModificationDto;
import edu.njmsd.stonksmonkey.boundaries.mappers.Mapper;
import edu.njmsd.stonksmonkey.domain.exceptions.ModelNotFoundException;
import edu.njmsd.stonksmonkey.domain.exceptions.ValidationException;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

abstract class BaseCategoryController {

    private final CrudService<OperationCategory> service;
    private final Mapper<OperationCategory, OperationCategoryDto> categoryDtoMapper;
    private final Mapper<OperationCategoryModificationDto, OperationCategory> categoryMapper;

    protected BaseCategoryController(
            CrudService<OperationCategory> service,
            Mapper<OperationCategory, OperationCategoryDto> categoryDtoMapper,
            Mapper<OperationCategoryModificationDto, OperationCategory> categoryMapper) {
        this.service = service;
        this.categoryDtoMapper = categoryDtoMapper;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ListResponse<OperationCategoryDto> getCategories() {
        var items = service.get().stream().map(categoryDtoMapper::map).collect(Collectors.toList());
        return new ListResponse<>(items);
    }

    @PostMapping
    public ResponseEntity<OperationCategoryDto> createCategory(
            @RequestBody OperationCategoryModificationDto modification,
            HttpServletRequest request) throws URISyntaxException {
        try {
            var category = service.create(categoryMapper.map(modification));
            var uri = new URI(request.getRequestURI() + "/" + category.getId());
            return ResponseEntity.created(uri).body(categoryDtoMapper.map(category));
        } catch (ValidationException exception) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public OperationCategoryDto updateCategory(
            @PathVariable long id,
            @RequestBody OperationCategoryModificationDto modification) {
        var category = categoryMapper.map(modification);
        category.setId(id);
        try {
            category = service.update(category);
        } catch (ValidationException exception) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        }
        return categoryDtoMapper.map(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id) {
        try {
            service.delete(id);
        } catch (ModelNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}
