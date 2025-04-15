package org.ayomide.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.ayomide.data.model.Gender;
@Getter
@Setter
public class DeleteStudentDtoResponse {

    private String studentId;

    private  String message;
}
