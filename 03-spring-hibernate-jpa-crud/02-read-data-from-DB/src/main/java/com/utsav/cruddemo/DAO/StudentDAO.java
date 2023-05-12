package com.utsav.cruddemo.DAO;

import com.utsav.cruddemo.entity.Student;

public interface StudentDAO {

    // save() is useful for saved object in database
    void save(Student theStudent);

    // find data from databse using ID
    Student findById(Integer id);
}
