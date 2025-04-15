package org.ayomide.services;


import org.ayomide.dto.request.CreateStudentDtoRequest;
import org.ayomide.dto.request.DeleteStudentDtoRequest;
import org.ayomide.dto.request.FindStudentDtoRequest;
import org.ayomide.dto.response.CreateStudentDtoResponse;
import org.ayomide.dto.response.DeleteStudentDtoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Test
    void createStudent() throws Exception {
        CreateStudentDtoRequest createStudentDtoRequest = new CreateStudentDtoRequest();
        createStudentDtoRequest.setName("Ayo");
        createStudentDtoRequest.setSchool("Ayo School");
        createStudentDtoRequest.setAge("40");
        createStudentDtoRequest.setGender("Male");
        assertTrue(service.createStudent(createStudentDtoRequest));
    }
    @Test
    void createSecondStudent() throws Exception {
        CreateStudentDtoRequest createStudentDtoRequest = new CreateStudentDtoRequest();
        createStudentDtoRequest.setName("Onyii");
        createStudentDtoRequest.setSchool("Semicolon");
        createStudentDtoRequest.setAge("20");
        createStudentDtoRequest.setGender("Female");
        assertTrue(service.createStudent(createStudentDtoRequest));
    }

    @Test
    void getStudent() throws Exception {
        createStudent();
        FindStudentDtoRequest findStudentDtoRequest = new FindStudentDtoRequest();
        findStudentDtoRequest.setStudentId("67fc1dd507a33f03f839605d");
        CreateStudentDtoResponse createStudentDtoResponse = service.getStudent(findStudentDtoRequest);
        assertNotNull(createStudentDtoResponse);
    }
    @Test
    void getSecondStudent() throws Exception {
        createSecondStudent();
        FindStudentDtoRequest findStudentDtoRequest = new FindStudentDtoRequest();
        findStudentDtoRequest.setStudentId("67fc2a95eefeb702a4b73347");
        CreateStudentDtoResponse createStudentDtoResponse = service.getStudent(findStudentDtoRequest);
        assertNotNull(createStudentDtoResponse);

    }

    @Test
    public void testDeleteStudent_Success() throws Exception {
        CreateStudentDtoRequest createStudentDtoRequest = new CreateStudentDtoRequest();

        createStudentDtoRequest.setName("Emmy");
        createStudentDtoRequest.setSchool("Semicolon");
        createStudentDtoRequest.setAge("27");
        createStudentDtoRequest.setGender("Male");
        CreateStudentDtoResponse createStudentDtoResponse = service.createSecondStudent(createStudentDtoRequest);


        DeleteStudentDtoRequest deleteStudentDtoRequest = new DeleteStudentDtoRequest();
        deleteStudentDtoRequest.setStudentId(createStudentDtoResponse.getStudentId());
        DeleteStudentDtoResponse deleteStudent  = service.deleteStudent(deleteStudentDtoRequest);

    assertEquals("Student Deleted Successfully!!",deleteStudent.getMessage());
    }
 @Test
    public void testThatCreateTwoStudent(){
     CreateStudentDtoRequest createStudentDtoRequestOne = new CreateStudentDtoRequest();
     CreateStudentDtoRequest createStudentDtoRequestTwo = new CreateStudentDtoRequest();
     createStudentDtoRequestOne.setName("Marvellous");
     createStudentDtoRequestOne.setSchool("Reality");
     createStudentDtoRequestOne.setAge("15");
     createStudentDtoRequestOne.setGender("Female");
     CreateStudentDtoResponse createStudentDtoResponseOne = service.createSecondStudent(createStudentDtoRequestOne);
     createStudentDtoRequestTwo.setName("Faith");
     createStudentDtoRequestTwo.setSchool("Reality");
     createStudentDtoRequestTwo.setAge("18");
     createStudentDtoRequestTwo.setGender("Male");
     CreateStudentDtoResponse createStudentDtoResponseTwo = service.createSecondStudent(createStudentDtoRequestTwo);
     assertEquals("Student Register Successfully!!",createStudentDtoResponseOne.getMessage());
     assertEquals("Student Register Successfully!!",createStudentDtoResponseTwo.getMessage());

 }
}