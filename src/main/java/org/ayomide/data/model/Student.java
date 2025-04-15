package org.ayomide.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class Student {

    @Id
    private String id;

    private String name;

    private String school;

    private String age;

    private Gender gender;
}
