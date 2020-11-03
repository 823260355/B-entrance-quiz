package com.thoughtworks.capability.gtb.entrancequiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupList {
    //TODO GTB-工程实践: - GroupList.java:13 learnerList数据的存储，不是这个dto的职责。数据存储相关的操作，应该由repository来做。
    public List<Learner> learnerList = new ArrayList();
    public int groupNum = 6;
    public static String TEAM_LASTFIX = " 组";

    int len = 0;

    Map<String, List<Learner>> groupLearner = new LinkedHashMap<>();

    //TODO GTB-工程实践: - GroupList.java:21 长方法，需要按模块抽取方法，进行重构
    //TODO GTB-工程实践: - GroupList.java:23  randomGroup这个操作不是dto的职责
    public Map<String, List<Learner>> randomGroup() {
        List<Learner> list = this.learnerList;
        Collections.shuffle(list);
        int groupMembers = this.len / this.groupNum;
        int remainderNum = this.len % this.groupNum;
        for (int i = 1; i <= groupNum; i++) {
            List<Learner> group = new ArrayList<>();
            for (int j = 0; j < groupMembers; j++) {
                group.add(list.get(i * groupMembers + j));
            }
            this.groupLearner.put(TEAM_LASTFIX + i, group);
        }

        Iterator<String> iterator = this.groupLearner.keySet().iterator();
        while (iterator.hasNext() && remainderNum-- != 0) {
            int index = len - remainderNum - 1;
            String key = iterator.next();
            this.groupLearner.get(key).add(list.get(index));
        }
        return this.groupLearner;
    }
}
