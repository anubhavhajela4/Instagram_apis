package com.blog.instagram_apis.config;

import com.blog.instagram_apis.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepo userRepo;
    @Bean
    public UserDetailsService userDetailsService() {
         return username -> (UserDetails) userRepo.findByEmail(username)
                 .orElseThrow(() -> new UsernameNotFoundException("User  not found"));
    }
}
