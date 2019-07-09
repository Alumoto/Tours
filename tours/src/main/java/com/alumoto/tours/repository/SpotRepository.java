package com.alumoto.tours.repository;

import java.util.List;

import com.alumoto.tours.domain.Spot;
import com.alumoto.tours.domain.Tour;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SpotRepository extends JpaRepository<Spot, Integer> {

    @Query("SELECT x FROM Spot x ORDER BY x.spotId")
    Page<Spot> findAllOrderById(Pageable pageable);

    List<Spot> findByParentTour(Tour tour);

}