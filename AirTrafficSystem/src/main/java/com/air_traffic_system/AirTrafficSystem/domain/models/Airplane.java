package com.air_traffic_system.AirTrafficSystem.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airplanes")
public class Airplane {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String prefix;
  private Float cruisingSpeed;
  private Integer autonomy;

  public Airplane() {}

  public Airplane(String prefix, Float cruisingSpeed, Integer autonomy) {
    this.prefix = prefix;
    this.cruisingSpeed = cruisingSpeed;
    this.autonomy = autonomy;
  }

  public int getId() {
    return id;
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
