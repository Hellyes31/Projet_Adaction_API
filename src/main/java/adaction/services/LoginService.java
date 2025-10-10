package adaction.services;

import adaction.models.SecurityConfig;
import adaction.models.Volunteer;
import adaction.models.LoginRequest;
import adaction.repositories.VolunteersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final VolunteersRepository volunteersRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(VolunteersRepository volunteersRepository, PasswordEncoder passwordEncoder) {
        this.volunteersRepository = volunteersRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Volunteer userAuthentification(String username, String password) {
        Volunteer volunteer = volunteersRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable !"));
        if(!passwordEncoder.matches(password, volunteer.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect !");
        } return volunteer;
    }
}
