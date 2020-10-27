package com.thoughtworks.capability.gtb.entrancequiz.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Learner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LearnerControllerTest {
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void should_return_list_is_success_when_get_learner_list() throws Exception {
        mockMvc.perform(get("/learners"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_create_learner_is_success() throws Exception {
        Learner learner = new Learner("小鲁班");
        String json = objectMapper.writeValueAsString(learner);
        mockMvc.perform(post("/create")
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}