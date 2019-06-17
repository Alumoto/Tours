package com.alumoto.tours.repository;

import com.alumoto.tours.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface UserRepository extends JpaRepository<User, String>{

    User findByUserName(String userName);

}

