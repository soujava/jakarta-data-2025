package org.soujava.demos.jakarta;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.By;
import jakarta.data.repository.Find;
import jakarta.data.repository.Repository;

import java.util.List;


@Repository
public interface Garage extends BasicRepository<Vehicle, String> {

    List<Vehicle> findByTransmission(Transmission transmission);

    @Find
    List<Vehicle> findBy(@By("transmission") Transmission transmission);
}
