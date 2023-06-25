package com.air_traffic_system.AirTrafficSystem.adapters.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.air_traffic_system.AirTrafficSystem.application.useCases.GetAllAirRoutesByDestinationUC;
import com.air_traffic_system.AirTrafficSystem.domain.models.AirRoute;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/airRoute")
public class AirRouteController {
  private GetAllAirRoutesByDestinationUC getAllAirRoutesByDestinationUC;

  @Autowired
  public AirRouteController(GetAllAirRoutesByDestinationUC getAllAirRoutesByDestinationUC) {
    this.getAllAirRoutesByDestinationUC = getAllAirRoutesByDestinationUC;
  }

  @GetMapping("/getAllAirRoutesByDestination")
  @CrossOrigin(origins = "*")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Returns a list of air routes by destination"),
    @ApiResponse(code = 500, message = "A server error occurred"),
  })
  @RequestMapping(value = "/getAllAirRoutesByDestination", method = RequestMethod.GET, produces="application/json")
  public List<AirRoute> getAllAirRoutesByDestination(String geoRefFrom, String geoRefTo) {
    return getAllAirRoutesByDestinationUC.run(geoRefFrom, geoRefTo);
  }
}
