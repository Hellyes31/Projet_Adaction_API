package adaction.services;

import adaction.models.City;
import adaction.models.Collect;
import adaction.models.Volunteer;
import adaction.repositories.CitiesRepository;
import adaction.repositories.CollectsRepository;
import adaction.repositories.VolunteersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
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

        if (collect.getVolunteerId() != null) {
            Long volunteerId = collect.getVolunteerId().longValue();
            Volunteer volunteer = volunteersRepository.findById(collect.getVolunteerId())
                    .orElseThrow(() -> new RuntimeException("Volunteer not found with id " + collect.getVolunteerId()));
            collect.setVolunteer(volunteer);
        }

        if (collect.getGlassNb() == null) collect.setGlassNb(0);
        if (collect.getButtNb() == null) collect.setButtNb(0);
        if (collect.getPlasticNb() == null) collect.setPlasticNb(0);
        if (collect.getElectronicsNb() == null) collect.setElectronicsNb(0);
        if (collect.getOthersNb() == null) collect.setOthersNb(0);
        if (collect.getVolunteerId() == null) collect.setVolunteerId(1L);

        return collectsRepository.save(collect);
    }

    public Optional<Collect> getCollectById(String id) {
        return collectsRepository.findById(Long.parseLong(id));
    }

    @Transactional
    public Optional<Collect> updateCollect(String id, Collect collectDetails) {
        return collectsRepository.findById(Long.parseLong(id))
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

                    if (collectDetails.getVolunteerId() != null) {
                        Volunteer volunteer = volunteersRepository.findById(collectDetails.getVolunteerId())
                                .orElseThrow(() -> new RuntimeException("Volunteer not found with id " + collectDetails.getVolunteerId()));
                        collect.setVolunteer(volunteer);
                    } else if (collectDetails.getVolunteer() != null) {
                        collect.setVolunteer(collectDetails.getVolunteer());
                    }

                    return collectsRepository.save(collect);
                });
    }

    @Transactional
    public boolean deleteCollect(String id) {
        return collectsRepository.findById(Long.parseLong(id))
                .map(collect -> {
                    collectsRepository.delete(collect);
                    return true;
                })
                .orElse(false);
    }

    public Map<String, Integer> getWasteByMonthAndVolunteer(int year, int month, Long volunteerId) {
        List<Collect> collects = collectsRepository.findByYearAndMonthAndVolunteer(year, month, volunteerId);

        Map<String, Integer> wasteData = new HashMap<>();
        wasteData.put("cigarettes", 0);
        wasteData.put("plastique", 0);
        wasteData.put("verre", 0);
        wasteData.put("electronique", 0);
        wasteData.put("autre", 0);

        for (Collect collect : collects) {
            wasteData.put("cigarettes", wasteData.get("cigarettes") + (collect.getButtNb() != null ? collect.getButtNb() : 0));
            wasteData.put("plastique", wasteData.get("plastique") + (collect.getPlasticNb() != null ? collect.getPlasticNb() : 0));
            wasteData.put("verre", wasteData.get("verre") + (collect.getGlassNb() != null ? collect.getGlassNb() : 0));
            wasteData.put("electronique", wasteData.get("electronique") + (collect.getElectronicsNb() != null ? collect.getElectronicsNb() : 0));
            wasteData.put("autre", wasteData.get("autre") + (collect.getOthersNb() != null ? collect.getOthersNb() : 0));
        }

        return wasteData;
    }

    public Map<String, Integer> getWasteByMonth(int year, int month) {
        List<Collect> collects = collectsRepository.findByYearAndMonth(year, month);

        Map<String, Integer> wasteData = new HashMap<>();
        wasteData.put("cigarettes", 0);
        wasteData.put("plastique", 0);
        wasteData.put("verre", 0);
        wasteData.put("electronique", 0);
        wasteData.put("autre", 0);

        for (Collect collect : collects) {
            wasteData.put("cigarettes", wasteData.get("cigarettes") + (collect.getButtNb() != null ? collect.getButtNb() : 0));
            wasteData.put("plastique", wasteData.get("plastique") + (collect.getPlasticNb() != null ? collect.getPlasticNb() : 0));
            wasteData.put("verre", wasteData.get("verre") + (collect.getGlassNb() != null ? collect.getGlassNb() : 0));
            wasteData.put("electronique", wasteData.get("electronique") + (collect.getElectronicsNb() != null ? collect.getElectronicsNb() : 0));
            wasteData.put("autre", wasteData.get("autre") + (collect.getOthersNb() != null ? collect.getOthersNb() : 0));
        }

        return wasteData;
    }
}