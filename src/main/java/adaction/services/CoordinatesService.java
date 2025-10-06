package adaction.services;

import adaction.repositories.CoordinatesRepository;
import adaction.models.Coordinate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinatesService {
    private final CoordinatesRepository coordinatesRepository;

    public CoordinatesService(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    // GET all
    public List<Coordinate> getAllCoordinates() {
        return coordinatesRepository.findAll();
    }

    // POST create
    public Coordinate createCoordinate(Coordinate coordinate) {
        return coordinatesRepository.save(coordinate);
    }

    // GET by ID
    public Optional<Coordinate> getCoordinateById(String id) {
        return coordinatesRepository.findById(id);
    }

    // PUT update
    public Optional<Coordinate> updateCoordinate(String id, Coordinate coordinateDetails) {
        Optional<Coordinate> coordinate = coordinatesRepository.findById(id);

        if(coordinate.isPresent()){
            Coordinate existingCoordinate = coordinate.get();
            existingCoordinate.setLatitude(coordinateDetails.getLatitude());
            existingCoordinate.setLongitude(coordinateDetails.getLongitude());
            existingCoordinate.setCity(coordinateDetails.getCity());

            Coordinate updatedCoordinate = coordinatesRepository.save(existingCoordinate);
            return Optional.of(updatedCoordinate);
        }

        return Optional.empty();
    }

    // DELETE
    public boolean deleteCoordinate(String id) {
        Optional<Coordinate> coordinate = coordinatesRepository.findById(id);

        if(coordinate.isPresent()){
            coordinatesRepository.delete(coordinate.get());
            return true;
        }
        return false;
    }
}