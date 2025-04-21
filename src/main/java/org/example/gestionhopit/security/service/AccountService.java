package org.example.gestionhopit.security.service;

import org.example.gestionhopit.security.entities.AppRole;
import org.example.gestionhopit.security.entities.AppUser;

public interface AccountService {
    AppUser addUser(String username, String password, String email, String confirmPassword);
    AppRole addRole(String roleName);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
}
