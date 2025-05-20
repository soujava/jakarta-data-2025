package org.soujava.demos.jakarta;

import jakarta.data.Sort;
import jakarta.data.page.CursoredPage;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
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
public interface Garage  {

    @Save
    Vehicle park(Vehicle vehicle);

    List<Vehicle> findByTransmission(Transmission transmission,
                                     Sort<Vehicle> sort);

    @Find
    List<Vehicle> byType(@By("transmission") Transmission transmission);

    @Query("from Vehicle where transmission = :transmission")
    Stream<Vehicle> query(@Param("transmission") Transmission transmission);

    @Find
    @OrderBy(_Vehicle.TYPE)
    CursoredPage<Vehicle> cursor(@By("transmission") Transmission transmission, PageRequest pageRequest);


    @Find
    @OrderBy(_Vehicle.MODEL)
    Page<Vehicle> offset(PageRequest pageRequest);

    @Find
    CursoredPage<Vehicle> findAll(PageRequest pageRequest, Sort<Vehicle> sort);
}
