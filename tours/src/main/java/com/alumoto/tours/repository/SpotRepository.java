package com.alumoto.tours.repository;

import com.alumoto.tours.domain.Spot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SpotRepository extends JpaRepository<Spot, Integer> {

    @Query("SELECT x FROM Spot x ORDER BY x.spotId")
    Page<Spot> findAllOrderByName(Pageable pageable);

}