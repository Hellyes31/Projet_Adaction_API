package adaction.services;

import adaction.models.WasteType;
import adaction.repositories.WasteTypeRepository;
import adaction.models.Volunteer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteTypeService {
    private final WasteTypeRepository wasteTypeRepository;

    public WasteTypeService(WasteTypeRepository wasteTypeRepository, WasteTypeRepository wasteTypeRepository1) {
        this.wasteTypeRepository = wasteTypeRepository;
    }

    // GET all
    public List<WasteType> getAllWasteType() {
        return wasteTypeRepository.findAll();
    }


    // GET by Label
    public Optional<WasteType> getLabelById(String id) {
        return wasteTypeRepository.findById(Long.parseLong(id));
    }
}
