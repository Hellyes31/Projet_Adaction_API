package adaction.services;

import adaction.models.Association;
import adaction.repositories.AssociationsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AssociationsService {

    private final AssociationsRepository associationsRepository;

    public AssociationsService(AssociationsRepository associationsRepository) {
        this.associationsRepository = associationsRepository;
    }

    public List<Association> getAllAssociation() {
        return associationsRepository.findAll();
    }


    public Optional<Association> getAssociationById(String id) {
        return associationsRepository.findById(Long.parseLong(id));
    }


    @Transactional
    public boolean deleteAssociation(String id) {
        return associationsRepository.findById(Long.parseLong(id))
                .map(collect -> {
                    associationsRepository.delete(collect);
                    return true;
                })
                .orElse(false);
    }
}
