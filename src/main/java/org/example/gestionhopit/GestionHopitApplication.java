package org.example.gestionhopit;

import org.example.gestionhopit.entities.Patient;
import org.example.gestionhopit.repository.PatientRepository;
import org.example.gestionhopit.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

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
//        Patient patient1 = Patient.builder()
//                .username("Abderrahmane")
//                .dateOfBirth(new Date())
//                .sick(false)
//                .score(90)
//                .build();
//
//        Patient patient2 = new Patient(null, "Mohammed", new Date(), true, 90);
//
//        patientRepository.save(patient1);
//        patientRepository.save(patient2);

    }

//    @Bean
//    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager) {
//        return args -> {
//            jdbcUserDetailsManager.createUser(User.withUsername("user11").password(passwordEncoder().encode("1234")).roles("USER").build());
//            jdbcUserDetailsManager.createUser(User.withUsername("user22").password(passwordEncoder().encode("1234")).roles("USER").build());
//            jdbcUserDetailsManager.createUser(User.withUsername("admin2").password(passwordEncoder().encode("1234")).roles("USER", "ADMIN").build());
//        };
//    }

//    @Bean
//    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService) {
//        return args -> {
//            accountService.addRole("USER");
//            accountService.addRole("ADMIN");
//            accountService.addUser("user1", "1234", "user1@gmail.com", "1234");
//            accountService.addUser("user2", "1234", "user2@gmail.com", "1234");
//            accountService.addUser("admin", "1234", "admin@gmail.com", "1234");
//            accountService.addRoleToUser("user1", "USER");
//            accountService.addRoleToUser("user2", "USER");
//            accountService.addRoleToUser("admin", "ADMIN");
//        };
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
