package edu.njmsd.stonksmonkey.api.controllers.operation;

import edu.njmsd.stonksmonkey.api.controllers.CrudController;
import edu.njmsd.stonksmonkey.api.dto.OperationDto;
import edu.njmsd.stonksmonkey.api.dto.OperationModificationDto;
import edu.njmsd.stonksmonkey.boundaries.mappers.Mapper;
import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
class ExpenseController extends CrudController<Operation, OperationDto, OperationModificationDto> {

    public ExpenseController(
            CrudService<Operation> expenseCrudService,
            Mapper<Operation, OperationDto> operationDtoMapper,
            Mapper<OperationModificationDto, Operation> operationMapper) {
        super(expenseCrudService, operationDtoMapper, operationMapper);
    }
}
