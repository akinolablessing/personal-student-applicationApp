package org.ayomide.data.repository;

import org.ayomide.data.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepo extends MongoRepository<Student, String> {
    Student findStudentById(String id);


}

