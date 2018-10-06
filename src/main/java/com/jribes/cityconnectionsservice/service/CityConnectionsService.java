package com.jribes.cityconnectionsservice.service;

import java.util.List;
import com.jribes.cityconnectionsservice.domain.City;
import com.jribes.cityconnectionsservice.entities.CityConnection;

public interface CityConnectionsService {
  /**
   * 
   * @param originCity City domain
   * @return
   */
  public List<CityConnection> getConnectionsByOriginCity(City originCity);
}
