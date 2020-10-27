package com.thoughtworks.capability.gtb.entrancequiz.domain;


import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LearnerEntity {
    @Id
    @GeneratedValue
    int id;

    @NonNull
    String name;
}
