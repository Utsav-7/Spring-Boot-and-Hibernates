package com.utsav.cruddemo.DAO;

import com.utsav.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    // save() is useful for saved object in database
    void save(Student theStudent);

    // find data from databse using ID
    Student findById(Integer id);

    // Find a data of the student from DB
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);

    // Update data in database
    void update(Student theStudent);
}
