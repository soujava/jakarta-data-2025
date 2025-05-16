package org.soujava.demos.jakarta;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import net.datafaker.Faker;

import java.util.Objects;

@Entity
public class Vehicle {

    @Id
    private String vin;
    @Column
    private String model;

    @Column
    private String type;

    @Column
    private Transmission transmission;

    public static Vehicle of(Faker faker) {
        var vehicle = faker.vehicle();
        Vehicle entity = new Vehicle();
        entity.vin = vehicle.vin();
        entity.model = vehicle.model();
        entity.type = vehicle.carType();
        entity.transmission = Transmission.of(vehicle.transmission());
        return entity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vin, vehicle.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vin);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}
