package pl.gregorymartin.as8.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherViewModelRepository extends JpaRepository<WeatherViewModel, Integer> {
}
