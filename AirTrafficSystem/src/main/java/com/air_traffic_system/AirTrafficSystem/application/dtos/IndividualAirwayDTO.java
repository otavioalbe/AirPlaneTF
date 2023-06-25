package com.air_traffic_system.AirTrafficSystem.application.dtos;

public class IndividualAirwayDTO {
  private Integer altitude;
  private Float occupationPercentage;
  
  public IndividualAirwayDTO(Integer altitude, Float occupationPercentage) {
    this.altitude = altitude;
    this.occupationPercentage = occupationPercentage;
  }

  public Integer getAltitude() {
    return altitude;
  }
  public Float getOccupationPercentage() {
    return occupationPercentage;
  } 
}
