package com.tele2.montyhall.service;

import com.tele2.montyhall.domain.Box;
import com.tele2.montyhall.domain.SimulationResult;
import org.springframework.stereotype.Service;

@Service
public interface SimulationService {
     SimulationResult startSimulation(long iterations);
}
