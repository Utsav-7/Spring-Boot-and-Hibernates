package com.utsav.cruddemo.DAO;

import com.utsav.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOimpl implements StudentDAO{

    // Define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    // Add @Transactional since we are performing an update
    @Override
    @Transactional
    public void save(Student theStudent){
        // Save theStudent in to database table
        entityManager.persist(theStudent);
    }
}
