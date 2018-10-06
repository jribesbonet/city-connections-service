package com.jribes.cityconnectionsservice.response;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.jribes.cityconnectionsservice.entities.CityConnection;

public class CityConnectionResponse {

  private Long id;
  private String originCity;
  private String destinationCity;
  private Date departureTime;
  private Date arrivalTime;

  public static List<CityConnectionResponse> createResponseBy(
      List<CityConnection> cityConnectionList) {

    List<CityConnectionResponse> cityConnectionResponseList = new ArrayList<>();

    for (CityConnection cityConnection : cityConnectionList) {
      CityConnectionResponse cityConnectionResponse = new CityConnectionResponse();
      cityConnectionResponse.setId(cityConnection.getId());
      cityConnectionResponse.setOriginCity(cityConnection.getOriginCity());
      cityConnectionResponse.setDestinationCity(cityConnection.getDestinationCity());
      cityConnectionResponse.setDepartureTime(cityConnection.getDepartureTime());
      cityConnectionResponse.setArrivalTime(cityConnection.getArrivalTime());
      cityConnectionResponseList.add(cityConnectionResponse);
    }

    return cityConnectionResponseList;

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


  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }

  public void setArrivalTime(Date arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  @Override
  public String toString() {
    return "CityConnectionResponse [id=" + id + ", originCity=" + originCity + ", destinationCity="
        + destinationCity + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
        + "]";
  }

}
