package edu.njmsd.stonksmonkey.api.controllers;

import edu.njmsd.stonksmonkey.api.models.GetOperationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operations/outcome")
public class OutcomeController {

    @GetMapping
    public ResponseEntity<GetOperationDto> getOutcomeOperations() {
        var operation = new GetOperationDto(123, -228, "", "");
        return ResponseEntity.status(HttpStatus.OK).body(operation);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOutcomeOperation(@RequestBody String body) {

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOperation(@RequestParam(value = "id") String id) {

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}