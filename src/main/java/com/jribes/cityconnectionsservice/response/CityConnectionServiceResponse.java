package com.jribes.cityconnectionsservice.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.jribes.cityconnectionsservice.entities.CityConnection;
import org.springframework.http.HttpStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel
public class CityConnectionServiceResponse implements Serializable {

  private static final String OK_DESCRIPTION = "City connections correctly returned";
  private static final String INTERNAL_SERVER_ERROR_DESCRIPTION =
      "Oops, an error has occurred, try again later...";

  @ApiModelProperty(value = "Status of the response", example = "200", required = true)
  private Integer responseStatus;
  @ApiModelProperty(value = "Description of the response", example = "Correct response",
      required = true)
  private String responseDescription;
  @ApiModelProperty(value = "List of the connection cities given an origin city")
  private List<CityConnectionResponse> cityConnectionResponseList;

  public static CityConnectionServiceResponse createCityConnectionServiceResponseOk(
      List<CityConnection> cityConnectionList) {

    CityConnectionServiceResponse cityConnectionServiceResponse =
        new CityConnectionServiceResponse();

    cityConnectionServiceResponse.setResponseDescription(OK_DESCRIPTION);
    cityConnectionServiceResponse.setResponseStatus(Integer.parseInt(HttpStatus.OK.toString()));

    List<CityConnectionResponse> cityConnectionResponseListBuilder = new ArrayList<>();

    for (CityConnection cityConnection : cityConnectionList) {
      CityConnectionResponse cityConnectionResponse = new CityConnectionResponse();
      cityConnectionResponse.setId(cityConnection.getId());
      cityConnectionResponse.setOriginCity(cityConnection.getOriginCity());
      cityConnectionResponse.setDestinationCity(cityConnection.getDestinationCity());
      cityConnectionResponse.setDepartureTime(cityConnection.getDepartureTime().getTime());
      cityConnectionResponse.setArrivalTime(cityConnection.getArrivalTime().getTime());
      cityConnectionResponseListBuilder.add(cityConnectionResponse);
    }

    cityConnectionServiceResponse.setCityConnectionResponseList(cityConnectionResponseListBuilder);

    return cityConnectionServiceResponse;
  }

  public static CityConnectionServiceResponse createCityConnectionServiceWithGenericError() {
    CityConnectionServiceResponse cityConnectionServiceResponse =
        new CityConnectionServiceResponse();
    cityConnectionServiceResponse.setResponseDescription(INTERNAL_SERVER_ERROR_DESCRIPTION);
    cityConnectionServiceResponse
        .setResponseStatus(Integer.parseInt(HttpStatus.INTERNAL_SERVER_ERROR.toString()));
    return cityConnectionServiceResponse;
  }

  public static CityConnectionServiceResponse createCityConnectionServiceWithCityNameException(
      String errorDescription) {
    CityConnectionServiceResponse cityConnectionServiceResponse =
        new CityConnectionServiceResponse();
    cityConnectionServiceResponse.setResponseDescription(errorDescription);
    cityConnectionServiceResponse
        .setResponseStatus(Integer.parseInt(HttpStatus.BAD_REQUEST.toString()));
    return cityConnectionServiceResponse;
  }

  public Integer getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
  }

  public String getResponseDescription() {
    return responseDescription;
  }

  public void setResponseDescription(String responseDescription) {
    this.responseDescription = responseDescription;
  }

  public List<CityConnectionResponse> getCityConnectionResponseList() {
    return cityConnectionResponseList;
  }

  public void setCityConnectionResponseList(
      List<CityConnectionResponse> cityConnectionResponseList) {
    this.cityConnectionResponseList = cityConnectionResponseList;
  }

  public static String getOkDescription() {
    return OK_DESCRIPTION;
  }

  @Override
  public String toString() {
    return "CityConnectionServiceResponse [responseStatus=" + responseStatus
        + ", responseDescription=" + responseDescription + ", cityConnectionResponseList="
        + cityConnectionResponseList + "]";
  }

}
