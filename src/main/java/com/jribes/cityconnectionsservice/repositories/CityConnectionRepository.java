package com.jribes.cityconnectionsservice.repositories;

import java.util.List;
import com.jribes.cityconnectionsservice.model.CityConnection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityConnectionRepository extends JpaRepository<CityConnection, Long> {

  List<CityConnection> findByOriginCity(String originCity);

  List<CityConnection> findByDestinationCity(String originCity);
}
