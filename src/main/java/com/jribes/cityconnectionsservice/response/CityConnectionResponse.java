package com.jribes.cityconnectionsservice.response;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel
public class CityConnectionResponse implements Serializable {

  @ApiModelProperty(value = "id of the connection flight", example = "0", required = true)
  private Long id;
  @ApiModelProperty(value = "Name of the origin city", example = "BCN", required = true)
  private String originCity;
  @ApiModelProperty(value = "Name of the destination city", example = "MAD", required = true)
  private String destinationCity;
  @ApiModelProperty(value = "Departure time from the origin city", example = "1540535400000",
      required = true)
  private Long departureTime;
  @ApiModelProperty(value = "Arrival time to destination city", example = "1540540800000",
      required = true)
  private Long arrivalTime;

  public Long getId() {
    return id;
  }

  public String getOriginCity() {
    return originCity;
  }

  public String getDestinationCity() {
    return destinationCity;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setOriginCity(String originCity) {
    this.originCity = originCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
  }

  public Long getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(Long departureTime) {
    this.departureTime = departureTime;
  }

  public Long getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(Long arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  @Override
  public String toString() {
    return "CityConnectionResponse [id=" + id + ", originCity=" + originCity + ", destinationCity="
        + destinationCity + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
        + "]";
  }

}
