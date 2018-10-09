package com.jribes.cityconnectionsservice.service;

import java.util.List;
import com.jribes.cityconnectionsservice.model.CityConnection;
import com.jribes.itinerarlib.domain.City;

public interface CityConnectionsService {
  /**
   * 
   * @param originCity City domain
   * @return
   */
  public List<CityConnection> getConnectionsByOriginCity(City originCity);

  public List<CityConnection> getConnectionsByDestinationCity(City destinationCity);
}
