package org.soujava.demos.jakarta;

import jakarta.nosql.Column;
import jakarta.nosql.Embeddable;


@Embeddable(Embeddable.EmbeddableType.GROUPING)
//@Embeddable(Embeddable.EmbeddableType.FLAT)
public record Manufacturer(@Column String name, @Column String address, @Column String contactNumber) {

}