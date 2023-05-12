package com.utsav.cruddemo.DAO;

import com.utsav.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    // find data from database using find(EntityClass, PrimaryKey) method
    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class.id);
    }

    // Find all student data from DB
    @Override
    public List<Student> findAll() {
        // create query
        // (ORDER BY fieldOfJPA is used for sort data asc and desc (BY default in asceding order))
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ",Student.class);

        // return query results
        return theQuery.getResultList();
    }

    // Find student data by last name
    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                                        "FROM Student WHERE lastname=:theData",Student.class);

        // set query parameters
        theQuery.setParameter("theData",theLastName);

        // return query results
        return theQuery.getResultList();
    }

    // Update a data in DB
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

}







