package com.jribes.cityconnectionsservice.controller;

import java.util.List;
import javax.inject.Inject;
import com.jribes.cityconnectionsservice.domain.City;
import com.jribes.cityconnectionsservice.entities.CityConnection;
import com.jribes.cityconnectionsservice.exception.IncorrectFormatCityException;
import com.jribes.cityconnectionsservice.response.CityConnectionResponse;
import com.jribes.cityconnectionsservice.service.CityConnectionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cityconnections")
public class CityConnectionsController {

  @Inject
  CityConnectionsService cityConnectionService;

  @GetMapping("/{originCity}")
  @ApiOperation(value = "Get all connection from an origin city")
  public List<CityConnectionResponse> getAllConnectionsByOriginCity(
      @PathVariable String originCityName) throws IncorrectFormatCityException {

    City originCity = City.createCity().withCityName(originCityName);
    List<CityConnection> cityConnectionsList =
        cityConnectionService.getConnectionsByOriginCity(originCity);

    return CityConnectionResponse.createResponseBy(cityConnectionsList);
  }
}
