package com.alumoto.tours.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alumoto.tours.repository.SpotRepository;

import java.util.Optional;

import com.alumoto.tours.domain.Spot;

@Service
@Transactional
public class SpotService {

    @Autowired
    SpotRepository spotRepository;

    public Page<Spot> findAll(Pageable pageable) {
        return spotRepository.findAllOrderByName(pageable);
    }

    public Optional<Spot> findById(Integer id) {
        return spotRepository.findById(id);
    }

    public Spot create(Spot spot) {
        return spotRepository.save(spot);
    }

    public Spot update(Spot spot) {
        return spotRepository.save(spot);
    }

    public void delete(Integer id) {
        spotRepository.deleteById(id);
    }
}