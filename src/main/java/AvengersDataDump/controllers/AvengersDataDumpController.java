package AvengersDataDump.controllers;

import AvengersDataDump.models.Avengers;
import AvengersDataDump.services.AvengersDataDumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AvengersDataDumpController {

    @Autowired
    private AvengersDataDumpService avengersDataDumpService;

    @GetMapping("/avengers/all")
    public Avengers allAvengers() throws IOException {
        return avengersDataDumpService.getAllAvengers();
    }
}
