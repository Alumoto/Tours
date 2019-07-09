package com.alumoto.tours.repository;

import java.util.List;
import java.util.Optional;

import com.alumoto.tours.domain.Tour;
import com.alumoto.tours.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TourRepository extends JpaRepository<Tour, Integer>{

    List<Tour> findByCreatorOrderByTourId(User creator);

}

