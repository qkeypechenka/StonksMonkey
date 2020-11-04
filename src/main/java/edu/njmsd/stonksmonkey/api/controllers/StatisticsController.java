package edu.njmsd.stonksmonkey.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operations/statistics")
public class StatisticsController {

    @GetMapping("/summary")
    public ResponseEntity<String> getSummaryStatistics() {

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @GetMapping
    public ResponseEntity<String> getUsingFilters(@RequestBody String filters) {

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}


