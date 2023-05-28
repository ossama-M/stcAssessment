package com.alzain.stcAssessment;

import com.alzain.stcAssessment.entity.AppRole;
import com.alzain.stcAssessment.entity.ServiceUser;
import com.alzain.stcAssessment.security.service.UserService;
import com.alzain.stcAssessment.service.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
public class StcAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StcAssessmentApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, ItemService itemService) {
        return args -> {

            userService.saveRole(new AppRole().builder().name("ROLE_USER").build());
            userService.saveRole(new AppRole().builder().name("ROLE_ADMIN").build());
            userService.saveRole(new AppRole().builder().name("ROLE_OWNER").build());

            userService.saveUser(new ServiceUser().builder().userEmail("ossama").password("1234").build());
            userService.saveUser(new ServiceUser().builder().userEmail("ahmed").password("1234").build());
            userService.saveUser(new ServiceUser().builder().userEmail("zain").password("1234").build());

            userService.addRoleToUser("ossama", "ROLE_ADMIN");
            userService.addRoleToUser("zain", "ROLE_OWNER");
            userService.addRoleToUser("ahmed", "ROLE_USER");
        };
    }
}
