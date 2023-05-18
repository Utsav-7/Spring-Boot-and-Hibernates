package com.utsav.cruddemo.dao;

import com.utsav.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

}
