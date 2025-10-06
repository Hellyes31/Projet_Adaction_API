package adaction.services;

import adaction.repositories.CitiesRepository;
import adaction.models.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesService {
    private final CitiesRepository citiesRepository;

    public CitiesService(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    // GET all
    public List<City> getAllCities() {
        return citiesRepository.findAll();
    }

    // POST create
    public City createCity(City city) {
        return citiesRepository.save(city);
    }

    // GET by ID
    public Optional<City> getCityById(String id) {
        return citiesRepository.findById(id);
    }

    // PUT update
    public Optional<City> updateCity(String id, City cityDetails) {
        Optional<City> city = citiesRepository.findById(id);

        if(city.isPresent()){
            City existingCity = city.get();
            existingCity.setName(cityDetails.getName());
            existingCity.setCoordinates_id(cityDetails.getCoordinates_id());

            City updatedCity = citiesRepository.save(existingCity);
            return Optional.of(updatedCity);
        }

        return Optional.empty();
    }

    // DELETE
    public boolean deleteCity(String id) {
        Optional<City> city = citiesRepository.findById(id);

        if(city.isPresent()){
            citiesRepository.delete(city.get());
            return true;
        }
        return false;
    }
}