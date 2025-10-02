package adaction.services;

import adaction.repositories.VolunteersRepository;
import adaction.models.Volunteer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteersService {
    private final VolunteersRepository volunteersRepository;

    public VolunteersService(VolunteersRepository volunteersRepository) {
        this.volunteersRepository = volunteersRepository;
    }

    public List<Volunteer> getAllVolunteers() {
        return this.volunteersRepository.findAll();
    }
}
