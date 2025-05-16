package org.soujava.demos.jakarta;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.By;
import jakarta.data.repository.Find;
import jakarta.data.repository.Param;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;

import java.util.List;
import java.util.stream.Stream;


@Repository
public interface Garage extends BasicRepository<Vehicle, String> {

    List<Vehicle> findByTransmission(Transmission transmission);

    @Find
    List<Vehicle> findBy(@By("transmission") Transmission transmission);

    @Query("from Vehicle where transmission = :transmission order by type asc")
    Stream<Vehicle> query(@Param("transmission") Transmission transmission);

}
