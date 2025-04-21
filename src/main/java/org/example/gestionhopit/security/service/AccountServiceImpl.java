package org.example.gestionhopit.security.service;

import lombok.AllArgsConstructor;
import org.example.gestionhopit.security.entities.AppRole;
import org.example.gestionhopit.security.entities.AppUser;
import org.example.gestionhopit.security.repo.AppRoleRepository;
import org.example.gestionhopit.security.repo.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final PasswordEncoder passwordEncoder;
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    @Override
    public AppUser addUser(String username, String password, String email, String confirmPassword) {
       AppUser user = appUserRepository.findByUsername(username);
       if(user!=null) throw new RuntimeException("User already exists");
       if(!password.equals(confirmPassword)) throw new RuntimeException("Passwords do not match");
       AppUser newUser = AppUser.builder()
               .id(UUID.randomUUID().toString())
               .username(username)
               .password(passwordEncoder.encode(password))
               .email(email)
               .build();

        return appUserRepository.save(newUser);
    }

    @Override
    public AppRole addRole(String roleName) {
        AppRole appRole = appRoleRepository.findById(roleName).orElse(null);
        if(appRole!=null) throw new RuntimeException("Role already exists");
        appRole = AppRole.builder()
                .role(roleName)
                .build();
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUsername(username);
        AppRole role = appRoleRepository.findById(roleName).orElse(null);
        if(user==null) throw new RuntimeException("User does not exist");
        if(role==null) throw new RuntimeException("Role does not exist");
        user.getRoles().add(role);
        //appUserRepository.save(user);
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUsername(username);
        AppRole role = appRoleRepository.findById(roleName).orElse(null);
        if(user==null) throw new RuntimeException("User does not exist");
        if(role==null) throw new RuntimeException("Role does not exist");
        user.getRoles().remove(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        AppUser user = appUserRepository.findByUsername(username);
        if(user==null) throw new RuntimeException("User does not exist");
        return user;
    }
}
