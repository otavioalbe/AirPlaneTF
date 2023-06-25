package com.air_traffic_system.AirTrafficSystem.adapters.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.air_traffic_system.AirTrafficSystem.application.dtos.AirwayFreeSlotDTO;
import com.air_traffic_system.AirTrafficSystem.application.dtos.AirwayReportDTO;
import com.air_traffic_system.AirTrafficSystem.application.useCases.GenerateAirwayReportUC;
import com.air_traffic_system.AirTrafficSystem.application.useCases.GetAirwayFreeSlotsUC;
import com.air_traffic_system.AirTrafficSystem.application.useCases.GetGeoRefByNameUC;
import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/airway")
public class AirwayController {
  private GetAirwayFreeSlotsUC getAirwayFreeSlotsUC;
  private GetGeoRefByNameUC getGeoRefByNameUC;
  private GenerateAirwayReportUC generateAirwayReportUC;

  @Autowired
  public AirwayController(GetAirwayFreeSlotsUC getAirwayFreeSlotsUC, GetGeoRefByNameUC getGeoRefByNameUC, GenerateAirwayReportUC generateAirwayReportUC) {
    this.getAirwayFreeSlotsUC = getAirwayFreeSlotsUC;
    this.getGeoRefByNameUC = getGeoRefByNameUC;
    this.generateAirwayReportUC = generateAirwayReportUC;
  }

  @GetMapping("/getAirwayFreeSlots")
  @CrossOrigin(origins = "*")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Returns a list of airway free slots"),
    @ApiResponse(code = 500, message = "A server error occurred"),
  })
  @RequestMapping(value = "/getAirwayFreeSlots", method = RequestMethod.GET, produces="application/json")
  public List<AirwayFreeSlotDTO> getAirwayFreeSlots(Date date, Float cruisingSpeed, String geoRefFrom, String geoRefTo) {
    return getAirwayFreeSlotsUC.run(date, cruisingSpeed, geoRefFrom, geoRefTo);
  }

  @GetMapping("/getGeoRefByName")
  @CrossOrigin(origins = "*")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Returns a geopraphic reference"),
    @ApiResponse(code = 500, message = "A server error occurred"),
  })
  @RequestMapping(value = "/getGeoRefByName", method = RequestMethod.GET, produces="application/json")
  public GeoRef getGeoRefByName(String name) {
    return getGeoRefByNameUC.run(name);
  }

  @GetMapping("/generateAirwayReport")
  @CrossOrigin(origins = "*")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Returns a airway occupation report"),
    @ApiResponse(code = 500, message = "A server error occurred"),
  })
  @RequestMapping(value = "/generateAirwayReport", method = RequestMethod.GET, produces="application/json")
  public AirwayReportDTO generateAirwayReport(String name, Date date) {
    return generateAirwayReportUC.run(name, date);
  }
}
