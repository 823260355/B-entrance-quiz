package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.domain.LearnerEntity;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Learner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnerRepository extends CrudRepository<LearnerEntity, Integer> {
    //TODO GTB-知识点: - LearnerRepository.java:12 JPA知识点使用错误，声明了自定义方法，但是没有指明sql，JPA无法正常解析
    List<Learner> getLearnerList();
}
