package org.example.gestionhopit.security.repo;

import org.example.gestionhopit.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
}
