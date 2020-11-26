package edu.njmsd.stonksmonkey.api.controllers.category;

import edu.njmsd.stonksmonkey.api.dto.OperationCategoryDto;
import edu.njmsd.stonksmonkey.api.dto.OperationCategoryModificationDto;
import edu.njmsd.stonksmonkey.boundaries.mappers.Mapper;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("expense-categories")
class ExpenseCategoryController extends BaseCategoryController {

    public ExpenseCategoryController(
            CrudService<OperationCategory> expenseCategoryCrudService,
            Mapper<OperationCategory, OperationCategoryDto> categoryDtoMapper,
            Mapper<OperationCategoryModificationDto, OperationCategory> categoryMapper) {
        super(expenseCategoryCrudService, categoryDtoMapper, categoryMapper);
    }
}
