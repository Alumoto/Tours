package com.alumoto.tours.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alumoto.tours.repository.SpotRepository;
import com.alumoto.tours.domain.Spot;

/**
 * Created by mitsuruog on 15/09/20.
 */
@Service
public class SpotService {

    @Autowired
    SpotRepository spotRepository;

    public Page<Spot> findAll(Pageable pageable) {
        return spotRepository.findAllOrderByName(pageable);
    }

    // public Spot findById(Integer spotid) {
    //     return spotRepository.findOne(spotid);
    // }

    public Spot create(Spot spot) {
        return spotRepository.save(spot);
    }

    public Spot update(Spot spot) {
        return spotRepository.save(spot);
    }

    // public void delete(Integer id) {
    //     spotRepository.delete(id);
    // }
}