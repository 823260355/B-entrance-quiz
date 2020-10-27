package com.thoughtworks.capability.gtb.entrancequiz.controller;


import com.thoughtworks.capability.gtb.entrancequiz.domain.LearnerEntity;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Learner;
import com.thoughtworks.capability.gtb.entrancequiz.repository.LearnerRepository;
import com.thoughtworks.capability.gtb.entrancequiz.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
public class LearnerController {
   @Autowired
    LearnerService learnerService;
   @Autowired
    static LearnerRepository learnerRepository;
    static List<Learner> learnerList;

    static {
        List<String> nameList = Arrays.asList("成吉思汗", "鲁班七号", "太乙真人", "钟无艳", "花木兰", "雅典娜",
                "芈月", "白起", "刘禅", "庄周", "马超", "刘备", "哪吒", "大乔", "蔡文姬");
        learnerList = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            LearnerEntity learnerEntity = LearnerEntity.builder()
                    .name(name)
                    .id(i + 1)
                    .build();
            learnerRepository.save(learnerEntity);
        }
    }
    @GetMapping(path = "/learners")
    public List<Learner> getLearnerList() {
        return learnerService.getLearnerList();
    }
}
