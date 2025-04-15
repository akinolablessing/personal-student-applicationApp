package org.ayomide.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.ayomide.data.model.Gender;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class CreateStudentDtoResponse {

    private String studentId;

    private String name;

    private String school;

    private String age;

    private Gender gender;

    private  String message;
}
