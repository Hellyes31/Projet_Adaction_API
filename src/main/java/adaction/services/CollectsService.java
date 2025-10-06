package adaction.services;

import adaction.models.City;
import adaction.models.Collect;
import adaction.models.Volunteer;
import adaction.repositories.CitiesRepository;
import adaction.repositories.CollectsRepository;
import adaction.repositories.VolunteersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CollectsService {

    private final CollectsRepository collectsRepository;
    private final VolunteersRepository volunteersRepository;
    private final CitiesRepository citiesRepository;

    public CollectsService(CollectsRepository collectsRepository,
                           VolunteersRepository volunteersRepository,
                           CitiesRepository citiesRepository) {
        this.collectsRepository = collectsRepository;
        this.volunteersRepository = volunteersRepository;
        this.citiesRepository = citiesRepository;
    }

    public List<Collect> getAllCollects() {
        return collectsRepository.findAll();
    }

    @Transactional
    public Collect createCollect(Collect collect) {
        if (collect.getCityId() != null) {
            City city = (City) citiesRepository.findById(collect.getCityId())
                    .orElseThrow(() -> new RuntimeException("City not found with id " + collect.getCityId()));
            collect.setCity(city);
        } else {
            throw new RuntimeException("city_id is required");
        }

        if (collect.getVolunteerName() != null && !collect.getVolunteerName().isEmpty()) {
            Volunteer volunteer = volunteersRepository.findByFirstname(collect.getVolunteerName())
                    .orElseGet(() -> {
                        Volunteer newVolunteer = new Volunteer();
                        newVolunteer.setFirstname(collect.getVolunteerName());
                        return volunteersRepository.save(newVolunteer);
                    });

            collect.setVolunteer(volunteer);
        }

        return collectsRepository.save(collect);
    }

    public Optional<Collect> getCollectById(String id) {
        return collectsRepository.findById(id);
    }

    @Transactional
    public Optional<Collect> updateCollect(String id, Collect collectDetails) {
        return collectsRepository.findById(id)
                .map(collect -> {
                    collect.setDate(collectDetails.getDate());
                    collect.setCity(collectDetails.getCity());
                    collect.setGlassNb(collectDetails.getGlassNb());
                    collect.setButtNb(collectDetails.getButtNb());
                    collect.setPlasticNb(collectDetails.getPlasticNb());
                    collect.setElectronicsNb(collectDetails.getElectronicsNb());
                    collect.setOthersNb(collectDetails.getOthersNb());

                    if (collectDetails.getCityId() != null) {
                        City city = (City) citiesRepository.findById(collectDetails.getCityId())
                                .orElseThrow(() -> new RuntimeException("Ville introuvable avec id " + collectDetails.getCityId()));
                        collect.setCity(city);
                    }

                    if (collectDetails.getVolunteerName() != null && !collectDetails.getVolunteerName().isEmpty()) {
                        Volunteer volunteer = volunteersRepository.findByFirstname(collectDetails.getVolunteerName())
                                .orElseGet(() -> {
                                    Volunteer newVolunteer = new Volunteer();
                                    newVolunteer.setFirstname(collectDetails.getVolunteerName());
                                    return volunteersRepository.save(newVolunteer);
                                });
                        collect.setVolunteer(volunteer);
                    } else if (collectDetails.getVolunteer() != null) {
                        collect.setVolunteer(collectDetails.getVolunteer());
                    }

                    return collectsRepository.save(collect);
                });
    }

    @Transactional
    public boolean deleteCollect(String id) {
        return collectsRepository.findById(id)
                .map(collect -> {
                    collectsRepository.delete(collect);
                    return true;
                })
                .orElse(false);
    }
}