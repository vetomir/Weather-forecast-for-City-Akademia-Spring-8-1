package pl.gregorymartin.as8.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import pl.gregorymartin.as8.model.WeatherViewModel;
import pl.gregorymartin.as8.service.WeatherService;

import java.util.List;


@RestController
@RequestMapping("/weather")
public class WeatherController {
    Logger logger = LoggerFactory.getLogger(WeatherController.class);
    private WeatherService service;

    public WeatherController(final WeatherService service) {
        this.service = service;

    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public boolean saveWeather(){
        service.getWeather("Warszawa");
        return true;
    }

    @GetMapping("/all")
    ResponseEntity<List<WeatherViewModel>> readAllTasks() {
        logger.warn("Exposing all weather details!");
        return ResponseEntity.ok(service.getAll());
    }


}
