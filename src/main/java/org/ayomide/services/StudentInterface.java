package org.ayomide.services;

import org.ayomide.dto.request.CreateStudentDtoRequest;
import org.ayomide.dto.request.DeleteStudentDtoRequest;
import org.ayomide.dto.request.FindStudentDtoRequest;
import org.ayomide.dto.response.CreateStudentDtoResponse;
import org.ayomide.dto.response.DeleteStudentDtoResponse;

public interface StudentInterface {

    boolean createStudent(CreateStudentDtoRequest createStudentDtoRequest) throws Exception;

    CreateStudentDtoResponse getStudent(FindStudentDtoRequest findStudentDtoRequest) throws Exception;


CreateStudentDtoResponse createSecondStudent(CreateStudentDtoRequest createStudentDtoRequest);
    DeleteStudentDtoResponse deleteStudent(DeleteStudentDtoRequest deleteStudentDtoRequest) throws Exception;
}
