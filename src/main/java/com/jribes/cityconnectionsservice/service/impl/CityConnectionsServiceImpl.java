package com.jribes.cityconnectionsservice.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import com.jribes.cityconnectionsservice.domain.City;
import com.jribes.cityconnectionsservice.entities.CityConnection;
import com.jribes.cityconnectionsservice.repositories.CityConnectionRepository;
import com.jribes.cityconnectionsservice.service.CityConnectionsService;

@Named
public class CityConnectionsServiceImpl implements CityConnectionsService {

  @Inject
  CityConnectionRepository repository;

  @Override
  public List<CityConnection> getConnectionsByOriginCity(City originCity) {
    return repository.findByOriginCity(originCity.getCityName());
  }

}
