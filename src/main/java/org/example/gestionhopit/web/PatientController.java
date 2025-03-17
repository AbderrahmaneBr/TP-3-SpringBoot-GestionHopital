package org.example.gestionhopit.web;

import lombok.AllArgsConstructor;
import org.example.gestionhopit.entities.Patient;
import org.example.gestionhopit.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model) {
        List<Patient> patientsList = patientRepository.findAll();
        model.addAttribute("patientsList", patientsList);
        return "index";
    }
}
