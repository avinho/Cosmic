package com.avinho.backend.services;

import com.avinho.backend.entities.user.User;
import com.avinho.backend.exceptions.ResourceNotFoundException;
import com.avinho.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Transactional
    public User updateUser(Long userId, Map<String, Object> fields) {
        User user = findUserById(userId);
        fields.forEach((key, value) -> {
            switch (key) {
                case "name" -> user.setName((String) value);
                case "username" -> user.setUsername((String) value);
                case "email" -> user.setEmail((String) value);
                case "password" -> {
                    String encryptedPass = new BCryptPasswordEncoder().encode((String) value);
                    user.setPassword(encryptedPass);
                }
            }
        });
        userRepository.save(user);
        return user;
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
