package com.air_traffic_system.AirTrafficSystem.application.dtos;

import java.util.ArrayList;
import java.util.List;

public class AirwayReportDTO {
  private List<IndividualAirwayDTO> individualAirways;

  public AirwayReportDTO() {
    this.individualAirways = new ArrayList<>();
  }

  public void addIndividualAirway(IndividualAirwayDTO individualAirwayDTO) {
    individualAirways.add(individualAirwayDTO);
  }
}
