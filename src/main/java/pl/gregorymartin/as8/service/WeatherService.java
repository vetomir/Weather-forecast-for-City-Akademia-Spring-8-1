package pl.gregorymartin.as8.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.gregorymartin.as8.api.WeatherClient;
import pl.gregorymartin.as8.model.WeatherViewModel;
import pl.gregorymartin.as8.model.WeatherViewModelRepository;

import java.util.List;

@Service
public class WeatherService {
    Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private WeatherViewModelRepository repository;
    private WeatherClient client;

    public WeatherService(final WeatherViewModelRepository repository, final WeatherClient client) {
        this.repository = repository;
        this.client = client;

    }



    public WeatherViewModel getWeather(String cityName){
        WeatherViewModel weatherModel
                = new WeatherViewModel(client.importData(cityName));
        repository.save(weatherModel);
        logger.info("Data for " + cityName + " saved!");
        return weatherModel;
    }

    public List<WeatherViewModel> getAll(){
        return repository.findAll();
    }
}
