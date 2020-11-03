package com.thoughtworks.capability.gtb.entrancequiz.controller;


import com.thoughtworks.capability.gtb.entrancequiz.config.Count;
import com.thoughtworks.capability.gtb.entrancequiz.domain.LearnerEntity;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Learner;
import com.thoughtworks.capability.gtb.entrancequiz.repository.LearnerRepository;
import com.thoughtworks.capability.gtb.entrancequiz.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class LearnerController {
    //TODO GTB-知识点: - LearnerController.java:21 对于Ioc容器管理的bean之间的注入，推荐使用构造器注入
   @Autowired
    LearnerService learnerService;
   //TODO GTB-工程实践: - LearnerController.java:24 最好不要跨层调用
   @Autowired
    static LearnerRepository learnerRepository;
    static List<Learner> learnerList;


    static {
        //TODO GTB-工程实践: - LearnerController.java:31 数据初始化的操作，不是controller的职责。
        List<String> nameList = Arrays.asList("成吉思汗", "鲁班七号", "太乙真人", "钟无艳", "花木兰", "雅典娜",
                "芈月", "白起", "刘禅", "庄周", "马超", "刘备", "哪吒", "大乔", "蔡文姬");
        learnerList = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            Count.count = i++;
            String name = nameList.get(i);
            LearnerEntity learnerEntity = LearnerEntity.builder()
                    .name(name)
                    .id(Count.count)
                    .build();
            learnerRepository.save(learnerEntity);
        }
    }

    @GetMapping(path = "/learners")
    public List<Learner> getLearnerList() {
        return learnerService.getLearnerList();
    }

    //TODO GTB-知识点: * 了解下@ReponseStatus的用法
    //TODO GTB-工程实践: - LearnerController.java:52 返回状态码，不符合restful实践，POST请求应该返回201
    //TODO GTB-知识点: - LearnerController.java:53  思考下，这个ResponseEntity是否可以省略？什么样的场景，才需要专门使用ResponseEntity进行返回？
    @CrossOrigin
    @PostMapping(path = "/create")
    public ResponseEntity addLearner(@RequestBody String name) {
        learnerService.addLearner(name);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/groupLearner")
    public ResponseEntity getLearnerGroups() {
        Map<String, List<Learner>> groupsLearner = learnerService.getLearnerGroups();
        return ResponseEntity.ok(groupsLearner);
    }
}
