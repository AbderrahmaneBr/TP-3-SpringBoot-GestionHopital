package org.example.gestionhopit.repository;

import org.example.gestionhopit.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByUsernameContains(String keyword, Pageable pageable);
    @Query("select p from Patient p where p.username like :x")
    Page<Patient> search(@Param("x") String x, Pageable pageable);
}
