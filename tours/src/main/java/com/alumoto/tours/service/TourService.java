package com.alumoto.tours.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.List;
import com.alumoto.tours.domain.Tour;
import com.alumoto.tours.domain.User;
import com.alumoto.tours.repository.TourRepository;

@Service
@Transactional
public class TourService {

    @Autowired
    TourRepository tourRepository;



    public List<Tour> findByCreator(User creator) {
        return tourRepository.findByCreatorOrderByTourId(creator);
    }

    public Tour create(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour update(Tour tour) {
        return tourRepository.save(tour);
    }

    public void delete(Integer id) {
        tourRepository.deleteById(id);
    }

	public Optional<Tour> findById(Integer id) {
		return tourRepository.findById(id);
	}
}