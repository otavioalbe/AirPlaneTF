package com.air_traffic_system.AirTrafficSystem.application.dtos;

public class AirplaneDTO {
  private String prefix;
  private Float cruisingSpeed;
  private Integer autonomy;

  public AirplaneDTO(String prefix, Float cruisingSpeed, Integer autonomy) {
    this.prefix = prefix;
    this.cruisingSpeed = cruisingSpeed;
    this.autonomy = autonomy;
  }

  public String getPrefix() {
    return prefix;
  }
  public Float getCruisingSpeed() {
    return cruisingSpeed;
  }
  public Integer getAutonomy() {
    return autonomy;
  }
}
