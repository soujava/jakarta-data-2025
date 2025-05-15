package org.soujava.demos.jakarta;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import net.datafaker.Faker;

@Entity
public class Vehicle {

    @Id
    private String id;
    @Column
    private String model;



    public static Vehicle of(Faker faker) {

    }
}
