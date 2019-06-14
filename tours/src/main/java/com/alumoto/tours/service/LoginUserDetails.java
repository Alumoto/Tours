package com.alumoto.tours.service;

import com.alumoto.tours.domain.User;
import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;

@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
    
    private final User user;

    public LoginUserDetails(User user){
        super(user.getUserName(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }
}