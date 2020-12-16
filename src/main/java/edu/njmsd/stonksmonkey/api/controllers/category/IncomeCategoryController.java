package edu.njmsd.stonksmonkey.api.controllers.category;

import edu.njmsd.stonksmonkey.api.controllers.CrudController;
import edu.njmsd.stonksmonkey.api.dto.OperationCategoryDto;
import edu.njmsd.stonksmonkey.api.dto.OperationCategoryModificationDto;
import edu.njmsd.stonksmonkey.boundaries.mappers.Mapper;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/income-categories")
class IncomeCategoryController extends CrudController<OperationCategory, OperationCategoryDto, OperationCategoryModificationDto> {

    public IncomeCategoryController(
            CrudService<OperationCategory> incomeCategoryCrudService,
            Mapper<OperationCategory, OperationCategoryDto> categoryDtoMapper,
            Mapper<OperationCategoryModificationDto, OperationCategory> categoryMapper) {
        super(incomeCategoryCrudService, categoryDtoMapper, categoryMapper);
    }
}
