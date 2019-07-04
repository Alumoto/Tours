package com.alumoto.tours.repository;

import com.alumoto.tours.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TourRepository extends JpaRepository<Tour, Integer>{

    Page<Tour> findByCreator(Pageable pageable);

}

