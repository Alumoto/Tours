package com.alumoto.tours.service;

import java.util.Optional;

import com.alumoto.tours.domain.User;
import com.alumoto.tours.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
 
    public Optional<User> findByUsername(String username){
        return Optional.ofNullable(userRepository.getOne(username));
    }

    public User create(User User, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User.setEncodedPassword(encodedPassword);
        User.setEnabled(true);
        return userRepository.save(User);
    }
}