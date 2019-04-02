package com.pyp.pypresale.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "produce")
public class Produce {

    @Id
    @GeneratedValue
    @Column(name = "ProduceID")
    private int produceID;


    @Column(name = "StudentID")
    private String studentID;

    @Column(name = "Title")
    private String title;

    @Column(name = "Type")
    private String type;

    @Column(name = "Text")
    private String text;

    @Column(name = "Saleing")
    private boolean saleing;

    @Column(name = "Price")
    private float price;

    @Column(name = "imageUrl")
    private String imageUrl;

    public Produce() {
    }

}
