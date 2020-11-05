package edu.njmsd.stonksmonkey.api.controllers.category;

import edu.njmsd.stonksmonkey.domain.models.OperationCategory;
import edu.njmsd.stonksmonkey.domain.services.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/income-categories")
class IncomeCategoryController extends BaseCategoryController {

    public IncomeCategoryController(CrudService<OperationCategory> incomeCategoryCrudService) {
        super(incomeCategoryCrudService);
    }
}
