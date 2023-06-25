package com.air_traffic_system.AirTrafficSystem.adapters.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.air_traffic_system.AirTrafficSystem.application.dtos.AirplaneDTO;
import com.air_traffic_system.AirTrafficSystem.application.useCases.GetAllAirplanesUC;
import com.air_traffic_system.AirTrafficSystem.application.useCases.InsertAirplanesUC;
import com.air_traffic_system.AirTrafficSystem.domain.models.Airplane;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {
  private InsertAirplanesUC insertAirplanesUC;
  private GetAllAirplanesUC getAllAirplanesUC;

  @Autowired
  public AirplaneController(InsertAirplanesUC insertAirplanesUC, GetAllAirplanesUC getAllAirplanesUC) {
    this.insertAirplanesUC = insertAirplanesUC;
    this.getAllAirplanesUC = getAllAirplanesUC;
  }

  @GetMapping("/getAll")
  @CrossOrigin(origins = "*")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Returns a list of airplanes"),
    @ApiResponse(code = 500, message = "A server error occurred"),
  })
  @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces="application/json")
  public List<Airplane> getAllAirplanes() {
    return getAllAirplanesUC.run();
  }

  @PostMapping("/insert")
  @CrossOrigin(origins = "*")
  public boolean insertAirplane(AirplaneDTO airplaneDto) {
    Airplane airplane = new Airplane(
      airplaneDto.getPrefix(), 
      airplaneDto.getCruisingSpeed(), 
      airplaneDto.getAutonomy()
    );

    return insertAirplanesUC.run(airplane);
  } 
}
