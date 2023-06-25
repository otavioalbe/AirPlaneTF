package com.air_traffic_system.AirTrafficSystem.application.useCases;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.application.dtos.AirwayReportDTO;
import com.air_traffic_system.AirTrafficSystem.domain.services.AirwayService;

@Component
public class GenerateAirwayReportUC {
  private AirwayService airwayService;

  @Autowired
  public GenerateAirwayReportUC(AirwayService airwayService) {
    this.airwayService = airwayService;
  }
  
  public AirwayReportDTO run(String name, Date date) {
    return airwayService.generateAirwayReport(name, date);
  }
}
