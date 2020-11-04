package edu.njmsd.stonksmonkey.api.controllers;


import edu.njmsd.stonksmonkey.api.models.AddOperationDto;
import edu.njmsd.stonksmonkey.api.models.GetOperationDto;
import edu.njmsd.stonksmonkey.api.models.UpdateOperationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operations/income")
public class IncomeController {

    @GetMapping
    public ResponseEntity<GetOperationDto> getIncomeOperations() {
        var operation = new GetOperationDto(123, 228, "", "");
        return ResponseEntity.status(HttpStatus.OK).body(operation);
    }

    @PutMapping("/add")
    public ResponseEntity<String> addIncomeOperation(@Validated @RequestBody AddOperationDto body) {

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<UpdateOperationDto> updateIncomeOperation(@RequestParam(value = "id") long id,
                                                                    @Validated @RequestBody UpdateOperationDto body) {

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOperation(@RequestParam(value = "id") String id) {

    }
}