package edu.njmsd.stonksmonkey.api.controllers.operation;

import edu.njmsd.stonksmonkey.domain.models.Operation;
import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.repositories.CrudRepository;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class ExpenseController extends BaseOperationController {

    public ExpenseController(
            CrudService<Operation> expenseCrudService,
            CrudRepository<OperationCategory> expenseCategoryCrudRepository) {
        super(expenseCrudService, expenseCategoryCrudRepository);
    }
}
