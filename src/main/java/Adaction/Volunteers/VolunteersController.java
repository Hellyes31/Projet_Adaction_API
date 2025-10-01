package Adaction.Volunteers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Adaction/Volunteers")
@CrossOrigin(origins = "http://localhost:5173")
public class VolunteersController {
    private final VolunteersService volunteersService;

    public VolunteersController(VolunteersService volunteersService) {
        this.volunteersService = volunteersService;
    }

    @GetMapping
    public List<Volunteers> getAllVolunteers() {
        return this.volunteersService.getAllVolunteers();
    }
}

