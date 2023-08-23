package com.springflutter.testtask.controllers;


import com.springflutter.testtask.entity.CounterDTO;
import com.springflutter.testtask.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private CounterService counterService;

    @Autowired
    public RestController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("/counter")
    public CounterDTO getCounter() {
        CounterDTO counterDTO = new CounterDTO();
        counterDTO.setValue(counterService.getCounter().getValue());
        return counterDTO;
    }

    @PostMapping("/counter")
    public void incrementCounter() {
        counterService.incrementCounter();
    }
}
