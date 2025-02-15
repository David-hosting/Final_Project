package com.backend.ifm.service;

import com.backend.ifm.entity.User;
import com.backend.ifm.repository.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            return new CustomUserDetails(
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()),
                    user.getCompanies().stream().map(company -> new SimpleGrantedAuthority(company.getName())).collect(Collectors.toList())
            );
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    public boolean userExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
