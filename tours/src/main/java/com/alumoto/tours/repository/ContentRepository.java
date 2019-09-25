package com.alumoto.tours.repository;

import java.util.List;

import com.alumoto.tours.domain.Spot;
import com.alumoto.tours.domain.Content;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ContentRepository extends JpaRepository<Content, Integer> {

    // @Query("SELECT x FROM Spot x ORDER BY x.contentId")
    // Page<Content> findAllOrderById(Pageable pageable);

    List<Content> findByParentSpot(Spot spot);

}