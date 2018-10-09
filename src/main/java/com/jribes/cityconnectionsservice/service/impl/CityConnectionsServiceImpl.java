package com.jribes.cityconnectionsservice.service.impl;

import java.util.List;
import com.jribes.cityconnectionsservice.model.CityConnection;
import com.jribes.cityconnectionsservice.repositories.CityConnectionRepository;
import com.jribes.cityconnectionsservice.service.CityConnectionsService;
import com.jribes.itinerarlib.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityConnectionsServiceImpl implements CityConnectionsService {

  @Autowired
  CityConnectionRepository repository;

  @Override
  public List<CityConnection> getConnectionsByOriginCity(City originCity) {
    return repository.findByOriginCity(originCity.getCityName());
  }

  @Override
  public List<CityConnection> getConnectionsByDestinationCity(City destinationCity) {
    return repository.findByDestinationCity(destinationCity.getCityName());
  }

}
