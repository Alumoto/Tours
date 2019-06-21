package com.alumoto.tours.service;

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
    UserRepository UserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
 
    public User create(User User, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User.setEncodedPassword(encodedPassword);
        User.setEnabled(true);
        return UserRepository.save(User);
    }
}