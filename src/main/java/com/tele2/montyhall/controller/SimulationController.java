package com.tele2.montyhall.controller;

import com.tele2.montyhall.domain.SimulationResult;
import com.tele2.montyhall.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/v1/simulation")
public class SimulationController {

    @Autowired
    private SimulationService simulationService;


    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("/start/{iterations}")
    public ResponseEntity<SimulationResult> start(@PathVariable long iterations){
      SimulationResult simulationResult = simulationService.startSimulation(iterations);
      return new ResponseEntity<>(simulationResult, HttpStatus.OK);

    }
}
