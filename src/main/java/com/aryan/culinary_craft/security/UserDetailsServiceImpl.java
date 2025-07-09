package com.aryan.culinary_craft.security;

import com.aryan.culinary_craft.model.User;
import com.aryan.culinary_craft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Custom logic: if isEncrypted is false, use plain password, else use encoded
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.isEncrypted() ? user.getPassword() : passwordEncoder.encode(user.getPassword()),
                Collections.singletonList(() -> "ROLE_" + user.getRole())
        );
    }
}
