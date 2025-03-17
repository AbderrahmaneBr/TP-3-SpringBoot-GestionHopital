package org.example.gestionhopit.repository;

import org.example.gestionhopit.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
