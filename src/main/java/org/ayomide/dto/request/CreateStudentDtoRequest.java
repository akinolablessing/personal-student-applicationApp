package org.ayomide.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentDtoRequest {


    private String name;

    private String school;

    private String age;

    private String gender;
}
