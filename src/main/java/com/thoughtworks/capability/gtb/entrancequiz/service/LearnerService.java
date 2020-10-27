package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Learner;
import com.thoughtworks.capability.gtb.entrancequiz.repository.LearnerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LearnerService {
    private final LearnerRepository learnerRepository;

    public LearnerService(LearnerRepository learnerRepository) {
        this.learnerRepository = learnerRepository;
    }

    public List<Learner> getLearnerList(){
        return learnerRepository.getLearnerList();
    }
}
