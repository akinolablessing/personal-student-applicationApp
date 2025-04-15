package org.ayomide.services;

import org.ayomide.data.model.Gender;
import org.ayomide.data.model.Student;
import org.ayomide.data.repository.StudentRepo;
import org.ayomide.dto.request.CreateStudentDtoRequest;
import org.ayomide.dto.request.DeleteStudentDtoRequest;
import org.ayomide.dto.request.FindStudentDtoRequest;
import org.ayomide.dto.response.CreateStudentDtoResponse;
import org.ayomide.dto.response.DeleteStudentDtoResponse;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentInterface {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public boolean createStudent(CreateStudentDtoRequest createStudentDtoRequest) throws Exception {
        Student student = new Student();
        student.setAge(createStudentDtoRequest.getAge());
        student.setName(createStudentDtoRequest.getName());
        student.setSchool(createStudentDtoRequest.getSchool());
        if (Gender.Male.toString().equalsIgnoreCase(createStudentDtoRequest.getGender()) || Gender.Female.toString().equalsIgnoreCase(createStudentDtoRequest.getGender())) {
            student.setGender(Gender.valueOf(createStudentDtoRequest.getGender()));
        } else {
            throw new Exception("Pick either Male or Famale");
        }
        studentRepo.save(student);
        return true;
    }


    @Override
    public CreateStudentDtoResponse getStudent(FindStudentDtoRequest findStudentDtoRequest) throws Exception {
        if (studentRepo.existsById(findStudentDtoRequest.getStudentId())) {
            Student student = studentRepo.findStudentById(findStudentDtoRequest.getStudentId());
            CreateStudentDtoResponse createStudentDtoResponse = new CreateStudentDtoResponse();
            createStudentDtoResponse.setAge(student.getAge());
            createStudentDtoResponse.setGender(student.getGender());
            return createStudentDtoResponse;
        } else {
            throw new Exception("Student Not Found");
        }
    }

    @Override
    public CreateStudentDtoResponse createSecondStudent(CreateStudentDtoRequest createStudentDtoRequest) {
        CreateStudentDtoResponse createStudentDtoResponse = new CreateStudentDtoResponse();
        Student student = new Student();
        student.setAge(createStudentDtoRequest.getAge());
        student.setName(createStudentDtoRequest.getName());
        student.setSchool(createStudentDtoRequest.getSchool());
        if (Gender.Male.toString().equalsIgnoreCase(createStudentDtoRequest.getGender()) || Gender.Female.toString().equalsIgnoreCase(createStudentDtoRequest.getGender())) {
            student.setGender(Gender.valueOf(createStudentDtoRequest.getGender()));
        } else {
            throw new RuntimeException("Pick either Male or Famale");
        }
        Student savedStudent = studentRepo.save(student);
        createStudentDtoResponse.setSchool(savedStudent.getSchool());
        createStudentDtoResponse.setName(savedStudent.getName());
        createStudentDtoResponse.setAge(savedStudent.getAge());
        createStudentDtoResponse.setGender(savedStudent.getGender());
        createStudentDtoResponse.setStudentId(savedStudent.getId());
        createStudentDtoResponse.setMessage("Student Register Successfully!!");
        return createStudentDtoResponse;
    }

    @Override
    public DeleteStudentDtoResponse deleteStudent(DeleteStudentDtoRequest deleteStudentDtoRequest)  {
        DeleteStudentDtoResponse deleteStudentDtoResponse = new DeleteStudentDtoResponse();
        if (studentRepo.existsById(deleteStudentDtoRequest.getStudentId())) {
            studentRepo.deleteById(deleteStudentDtoRequest.getStudentId());
            deleteStudentDtoResponse.setStudentId(deleteStudentDtoResponse.getStudentId());
            deleteStudentDtoResponse.setMessage("Student Deleted Successfully!!");
           return deleteStudentDtoResponse;
        }
        throw new RuntimeException("Student ID must be provided.");
    }



}


