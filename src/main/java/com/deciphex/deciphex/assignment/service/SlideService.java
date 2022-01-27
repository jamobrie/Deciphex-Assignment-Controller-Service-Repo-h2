package com.deciphex.deciphex.assignment.service;

import com.deciphex.deciphex.assignment.converter.ConversionHelper;
import com.deciphex.deciphex.assignment.exception.InvalidSlideNameException;
import com.deciphex.deciphex.assignment.exception.SlideDoesNotExistForThatNameException;
import com.deciphex.deciphex.assignment.models.Slide;
import com.deciphex.deciphex.assignment.repository.SlideRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@AllArgsConstructor
public class SlideService {

    private final ConversionHelper conversionHelper;
    private final SlideRepository slideRepository;

    public Slide updateSlideInfo(Slide slideToUpdate) {

        Optional<com.deciphex.deciphex.assignment.entities.Slide> existingSlide = slideRepository.findBySlideName(slideToUpdate.getSlideName());

        if (existingSlide.isEmpty()) {
            throw new SlideDoesNotExistForThatNameException(slideToUpdate.getSlideName());
        }

        return conversionHelper.convertSlideEntityToModel(slideRepository.save(existingSlide.get()));

    }

    public Slide findSlide(String slideName) {

        if (isBlank(slideName)) {
            throw new InvalidSlideNameException();
        }

        Optional<com.deciphex.deciphex.assignment.entities.Slide> existingSlide = slideRepository.findBySlideName(slideName);

        if (existingSlide.isEmpty()) {
            throw new SlideDoesNotExistForThatNameException(slideName);
        }

        return conversionHelper.convertSlideEntityToModel(existingSlide.get());

    }
}
