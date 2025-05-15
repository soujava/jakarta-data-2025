package org.soujava.demos.jakarta;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;


@Repository
public interface Garage extends BasicRepository<Vehicle, String> {
}
