package com.alumoto.tours.service;

import com.alumoto.tours.domain.User;
import com.alumoto.tours.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
 
@Component
public class JpaUserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
 
        User user = userRepository.findByUserName(userName);
        return user;
    }
}