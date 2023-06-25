package com.air_traffic_system.AirTrafficSystem.adapters.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.air_traffic_system.AirTrafficSystem.application.useCases.CancelFlightPlanUC;
import com.air_traffic_system.AirTrafficSystem.application.useCases.CheckFlightPlanUC;
import com.air_traffic_system.AirTrafficSystem.application.useCases.DispatchFlightPlanUC;
import com.air_traffic_system.AirTrafficSystem.domain.models.AirwayOccupation;
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
@RequestMapping("/airway")
public class FlightPlanController {
  private CheckFlightPlanUC checkFlightPlanUC;
  private DispatchFlightPlanUC dispatchFlightPlanUC;
  private CancelFlightPlanUC cancelFlightPlanUC;

  @Autowired
  public FlightPlanController(CheckFlightPlanUC checkFlightPlanUC, DispatchFlightPlanUC dispatchFlightPlanUC, CancelFlightPlanUC cancelFlightPlanUC) {
    this.checkFlightPlanUC = checkFlightPlanUC;
    this.dispatchFlightPlanUC = dispatchFlightPlanUC;
    this.cancelFlightPlanUC = cancelFlightPlanUC;
  }

  @GetMapping("/checkFlightPlan")
  @CrossOrigin(origins = "*")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Returns a list of air occupations"),
    @ApiResponse(code = 500, message = "A server error occurred"),
  })
  @RequestMapping(value = "/checkFlightPlan", method = RequestMethod.GET, produces="application/json")
  public List<AirwayOccupation> checkFlightPlan(int flightNumber, String geoRefFrom, String geoRefTo) {
    return checkFlightPlanUC.run(flightNumber, geoRefFrom, geoRefTo);
  }

  @PostMapping("/dispatchFlightPlan")
  @CrossOrigin(origins = "*")
  public boolean dispatchFlightPlan(int flightNumber, String geoRefFrom, String geoRefTo) {
    return dispatchFlightPlanUC.run(flightNumber, geoRefFrom, geoRefTo);
  }

  @PostMapping("/cancelFlightPlan")
  @CrossOrigin(origins = "*")
  public boolean getGeoRefByName(int flightNumber, String geoRefFrom, String geoRefTo) {
    return cancelFlightPlanUC.run(flightNumber, geoRefFrom, geoRefTo);
  }
}
