package org.example.gestionhopit;

import org.example.gestionhopit.entities.Patient;
import org.example.gestionhopit.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class GestionHopitApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionHopitApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient1 = Patient.builder()
                .username("Abderrahmane")
                .dateOfBirth(new Date())
                .isSick(false)
                .score(90)
                .build();

        Patient patient2 = new Patient(null, "Mohammed", new Date(), true, 90);

        patientRepository.save(patient1);
        patientRepository.save(patient2);

    }
}
