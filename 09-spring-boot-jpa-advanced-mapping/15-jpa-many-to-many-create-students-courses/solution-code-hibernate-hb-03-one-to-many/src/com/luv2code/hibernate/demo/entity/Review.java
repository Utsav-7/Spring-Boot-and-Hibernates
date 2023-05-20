package com.luv2code.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review{

    // define fields

    // define constructor

    // define getter / setter methods

    // annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    public Review(){
    }

    public Review(String comment) {
        this.comment=comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}