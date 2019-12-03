package com.klmhva.LineMaintenanceBackend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.klmhva.LineMaintenanceBackend.model.Run;
import com.klmhva.LineMaintenanceBackend.repository.RunRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/run")
public class RunController {

    @Autowired
    private RunRepository runRepository;

    @GetMapping("/getRuns")
    public List<Run> getRuns() {
        return (List<Run>) runRepository.findAll();
    }

    @PostMapping("/postRun")
    public String postRun(@RequestBody Run run) {
        System.out.println(run);
        runRepository.save(run);
        return "Run posted";
    }
}
