package com.alumoto.tours.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alumoto.tours.repository.ContentRepository;
import com.alumoto.tours.repository.TourRepository;

import java.util.List;
import java.util.Optional;

import com.alumoto.tours.domain.Content;
import com.alumoto.tours.domain.Tour;

@Service
@Transactional
public class ContentService {

    @Autowired
    ContentRepository contentRepository;

    // public Page<Content> findAll(Pageable pageable) {
    //     return contentRepository.findAllOrderById(pageable);
    // }

    public Optional<Content> findById(Integer id) {
        return contentRepository.findById(id);
    }

    public Content create(Content content) {
        return contentRepository.save(content);
    }

    public Content update(Content content) {
        return contentRepository.save(content);
    }

    public void delete(Integer contentId) {
        
        Content content = contentRepository.findById(contentId).get();
        List<Content> contentList = contentRepository.findByParentSpot(content.getParentSpot());
        for(Content eachcontent : contentList){
            if(eachcontent.getContentNo() > content.getContentNo()){
                eachcontent.setContentNo(eachcontent.getContentNo() - 1);
            }
            contentRepository.save(eachcontent);
        }
        contentRepository.deleteById(contentId);
    }
}