package com.air_traffic_system.AirTrafficSystem.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Aeroporto")
public class GeoRef {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(unique=true)
  private String name;


  public GeoRef() {}

  public GeoRef(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }
  public String getName() {
    return name;
  }
 
}
