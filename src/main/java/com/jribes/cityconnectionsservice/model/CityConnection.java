package com.jribes.cityconnectionsservice.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class CityConnection {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String originCity;
  private String destinationCity;
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date departureTime;
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date arrivalTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOriginCity() {
    return originCity;
  }

  public void setOriginCity(String originCity) {
    this.originCity = originCity;
  }

  public String getDestinationCity() {
    return destinationCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
  }

  public Date getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }

  public Date getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(Date arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  @Override
  public String toString() {
    return "CityConnection [id=" + id + ", originCity=" + originCity + ", destinationCity="
        + destinationCity + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
        + "]";
  }

}
