package adaction.services;

import adaction.models.SecurityConfig;
import adaction.repositories.VolunteersRepository;
import adaction.models.Volunteer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteersService {
    private final VolunteersRepository volunteersRepository;
    private final PasswordEncoder passwordEncoder;

    public VolunteersService(VolunteersRepository volunteersRepository, PasswordEncoder passwordEncoder) {
        this.volunteersRepository = volunteersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // GET all
    public List<Volunteer> getAllVolunteers() {
        return volunteersRepository.findAll();
    }

    // POST create
    public Volunteer createVolunteer(Volunteer volunteer) {

        if (volunteer.getPassword() != null && !volunteer.getPassword().isEmpty()) {
            String encoded = passwordEncoder.encode(volunteer.getPassword());
            volunteer.setPassword(encoded);
        }

        return volunteersRepository.save(volunteer);
    }

    // GET by ID
    public Optional<Volunteer> getVolunteerById(String id) {
        return volunteersRepository.findById(Long.parseLong(id));
    }

    // PUT update
    public Optional<Volunteer> updateVolunteer(String id, Volunteer volunteerDetails) {
        Optional<Volunteer> volunteer = volunteersRepository.findById(Long.parseLong(id));

        if(volunteer.isPresent()){
            Volunteer existingVolunteer = volunteer.get();
            existingVolunteer.setFirstname(volunteerDetails.getFirstname());
            existingVolunteer.setLastname(volunteerDetails.getLastname());
            existingVolunteer.setEmail(volunteerDetails.getEmail());
            existingVolunteer.setPassword(volunteerDetails.getPassword());
            existingVolunteer.setLocation(volunteerDetails.getLocation());
            existingVolunteer.setTotal_points(volunteerDetails.getTotal_points());
            existingVolunteer.setDonation_points(volunteerDetails.getDonation_points());
            existingVolunteer.setCreated_at(volunteerDetails.getCreated_at());
            existingVolunteer.setUpdated_at(volunteerDetails.getUpdated_at());

            if(volunteerDetails.getPassword() !=null && !volunteerDetails.getPassword().isEmpty()){
                String encoded = passwordEncoder.encode(volunteerDetails.getPassword());
                existingVolunteer.setPassword(encoded);
            }


            Volunteer updatedVolunteer = volunteersRepository.save(existingVolunteer);
            return Optional.of(updatedVolunteer);
        }

        return Optional.empty();
    }

    // DELETE
    public boolean deleteVolunteer(String id) {
        Optional<Volunteer> volunteer = volunteersRepository.findById(Long.parseLong(id));

        if(volunteer.isPresent()){
            volunteersRepository.delete(volunteer.get());
            return true;
        }
        return false;
    }
}

