package org.soujava.demos.jakarta;

import jakarta.data.Order;
import jakarta.data.Sort;
import jakarta.data.page.CursoredPage;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.By;
import jakarta.data.repository.Find;
import jakarta.data.repository.OrderBy;
import jakarta.data.repository.Param;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;
import jakarta.data.repository.Save;

import java.util.List;
import java.util.stream.Stream;


@Repository
public interface Garage {

    List<Vehicle> findByTransmission(Transmission transmission);

    @Find
    List<Vehicle> findBy(@By("transmission") Transmission transmission, Sort<Vehicle> order);

    @Query("from Vehicle where transmission = :transmission order by type asc")
    Stream<Vehicle> query(@Param("transmission") Transmission transmission);

    @Save
    Vehicle parking(Vehicle vehicle);

    @Find
    @OrderBy(_Vehicle.MODEL)
    CursoredPage<Vehicle> findAll(PageRequest pageRequest);
}
