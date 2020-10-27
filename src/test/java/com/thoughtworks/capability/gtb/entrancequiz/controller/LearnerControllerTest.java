package com.thoughtworks.capability.gtb.entrancequiz.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LearnerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setup() {

    }
    @Test
    public void should_return_list_is_success_when_get_learner_list() throws Exception {
        mockMvc.perform(get("/learners"))
                .andExpect(status().isOk());
    }
}