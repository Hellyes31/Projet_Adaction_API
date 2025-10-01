package Adaction.Volunteers;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteersService {
    private final VolunteersRepository volunteersRepository;

    public VolunteersService(VolunteersRepository volunteersRepository) {
        this.volunteersRepository = volunteersRepository;
    }

    public List<Volunteers> getAllVolunteers() {
        return this.volunteersRepository.findAll();
    }
}
