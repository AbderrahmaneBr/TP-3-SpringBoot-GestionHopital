package org.example.gestionhopit.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.gestionhopit.entities.Patient;
import org.example.gestionhopit.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
                        @RequestParam(name = "size", defaultValue = "1") int s,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        // List<Patient> patientsList = patientRepository.findAll();
        Page<Patient> patientPage;
        if(keyword.isEmpty()) {
            patientPage = patientRepository.findAll(PageRequest.of(p, s));
        } else {
            patientPage = patientRepository.findByUsernameContains(keyword, PageRequest.of(p, s));
        }
        model.addAttribute("patientsList", patientPage.getContent());
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", p);
        model.addAttribute("keyword", keyword);

        return "index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id,
                         @RequestParam(name = "page") int currentPage,
                         @RequestParam(name = "keyword") String keyword) {
        patientRepository.deleteById(id);
        return "redirect:/index" + "?page=" + currentPage + "&keyword=" + keyword;
    }

    @GetMapping("/formPatients")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "form-patients";
    }

    @PostMapping("/save")
    public String savePatient(@Valid @ModelAttribute("patient") Patient patient,
                              BindingResult bindingResult,
                              Model model, @RequestParam(name = "page") int currentPage,
                              @RequestParam(name = "keyword") String keyword) {
        if (bindingResult.hasErrors()) {
            return "form-patients"; // Return the form with errors
        }

        patientRepository.save(patient);

        // Save patient logic here
        return "redirect:/index" + "?page=" + currentPage + "&keyword=" + keyword;
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") Long id, @RequestParam(name = "page") int currentPage,
                       @RequestParam(name = "keyword") String keyword) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if(patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }
        model.addAttribute("patient", patient);
        model.addAttribute("page", currentPage);
        model.addAttribute("keyword", keyword);

        return "edit-patient";
    }

}
