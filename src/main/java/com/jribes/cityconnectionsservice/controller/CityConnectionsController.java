package com.jribes.cityconnectionsservice.controller;

import java.util.List;
import com.jribes.cityconnectionsservice.model.CityConnection;
import com.jribes.cityconnectionsservice.response.CityConnectionServiceResponse;
import com.jribes.cityconnectionsservice.service.CityConnectionsService;
import com.jribes.itinerarlib.domain.City;
import com.jribes.itinerarlib.exception.IncorrectFormatCityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cityconnections")
public class CityConnectionsController {

  private Logger logger = LoggerFactory.getLogger(CityConnectionsController.class);

  @Autowired
  CityConnectionsService cityConnectionService;

  @GetMapping("/origin/{originCityName}")
  @ApiOperation(value = "Get all connection from an origin city")
  public ResponseEntity<CityConnectionServiceResponse> getAllConnectionsByOriginCity(
      @PathVariable String originCityName) throws IncorrectFormatCityException {

    logger.info("getAllConnectionsByOriginCity method called");

    City originCity = City.createCity().withCityName(originCityName);

    List<CityConnection> cityConnectionsList =
        cityConnectionService.getConnectionsByOriginCity(originCity);

    return new ResponseEntity<CityConnectionServiceResponse>(
        CityConnectionServiceResponse.createCityConnectionServiceResponseOk(cityConnectionsList),
        HttpStatus.OK);
  }

  @GetMapping("/destination/{destinationCityName}")
  @ApiOperation(value = "Get all connection from a destination city")
  public ResponseEntity<CityConnectionServiceResponse> getAllConnectionsByDestinationCity(
      @PathVariable String destinationCityName) throws IncorrectFormatCityException {

    logger.info("getAllConnectionsByOriginCity method called");

    City originCity = City.createCity().withCityName(destinationCityName);

    List<CityConnection> cityConnectionsList =
        cityConnectionService.getConnectionsByDestinationCity(originCity);

    return new ResponseEntity<CityConnectionServiceResponse>(
        CityConnectionServiceResponse.createCityConnectionServiceResponseOk(cityConnectionsList),
        HttpStatus.OK);
  }
}
