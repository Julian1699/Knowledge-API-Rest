package com.api.rest.service;

import com.api.rest.domain.User;
import com.api.rest.domain.UserRole;
import com.api.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));

        String[] roles = user.getRoles().stream().map(UserRole::getRole).toArray(String[]::new);

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
                .accountLocked(user.getLocked())
                .disabled(user.getDisabled())
                .build();
    }
}