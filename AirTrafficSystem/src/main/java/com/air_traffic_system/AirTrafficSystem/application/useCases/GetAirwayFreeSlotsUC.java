package com.air_traffic_system.AirTrafficSystem.application.useCases;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.application.dtos.AirwayFreeSlotDTO;
import com.air_traffic_system.AirTrafficSystem.domain.services.AirwayService;

@Component
public class GetAirwayFreeSlotsUC {
  private AirwayService airwayService;

  @Autowired
  public GetAirwayFreeSlotsUC(AirwayService airwayService) {
    this.airwayService = airwayService;
  }
  
  public List<AirwayFreeSlotDTO> run(Date date, Float cruisingSpeed, String geoRefFrom, String geoRefTo) {
    return airwayService.getAirwayFreeSlots(date, cruisingSpeed, geoRefFrom, geoRefTo);
  }
}
