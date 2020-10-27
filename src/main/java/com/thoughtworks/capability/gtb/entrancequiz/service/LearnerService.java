package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.config.Count;
import com.thoughtworks.capability.gtb.entrancequiz.domain.LearnerEntity;
import com.thoughtworks.capability.gtb.entrancequiz.dto.GroupList;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Learner;
import com.thoughtworks.capability.gtb.entrancequiz.repository.LearnerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class LearnerService {


    private final LearnerRepository learnerRepository;

    public LearnerService(LearnerRepository learnerRepository) {
        this.learnerRepository = learnerRepository;
    }

    public List<Learner> getLearnerList(){
        return learnerRepository.getLearnerList();
    }

    public void addLearner(String name) {
        LearnerEntity learnerEntity = LearnerEntity.builder()
                .id(Count.count++)
                .name(name)
                .build();
        learnerRepository.save(learnerEntity);
    }

    public Map<String,List<Learner>> getLearnerGroups() {
        return new GroupList().randomGroup();
    }
}

