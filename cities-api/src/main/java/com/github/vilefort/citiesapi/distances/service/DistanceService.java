package com.github.vilefort.citiesapi.distances.service;

import java.util.Arrays;
import java.util.List;
import com.github.vilefort.citiesapi.cities.City;
import com.github.vilefort.citiesapi.cities.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    private final CityRepository cityRepository;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    public Double distanceByPointsInMiles(final Long city1, final Long city2) {
        log.info("nativePostgresInMiles({}, {})", city1, city2);
        return cityRepository.distanceByPoints(city1, city2);
    }

    /**
     * 3rd option
     *
     * @param city1
     * @param city2
     * @param unit
     * @return

    public Double distanceUsingPoints(final Long city1, final Long city2, final EarthRadius unit) {
        log.info("distanceUsingPoints({}, {}, {})", city1, city2, unit);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return doCalculation(p1.getX(), p1.getY(), p2.getX(), p2.getY(), unit);
    }  */

    /**
     * 4th option
     *
     * @param city1
     * @param city2
     * @return
    */
    public Double distanceByCubeInMeters(Long city1, Long city2) {
        log.info("distanceByCubeInMeters({}, {})", city1, city2);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }


    /**
     * Service de proximidade por raio
     * @param cityId
     * @param radius
     * @return

    public List<City> nearby(Long cityId, Double radius) {
        Optional<City> city = cityRepository.findById(cityId);

        if (city.isPresent()) {
            Point point = city.get().getLocation();

            return cityRepository.citiesByRadius(point.getX(), point.getY(), radius);
        }
        return Collections.emptyList();
    } */
}

