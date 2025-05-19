/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package org.soujava.demos.jakarta;



import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import net.datafaker.Faker;

import java.util.logging.Logger;




public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        var faker = new Faker();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            var garage = container.select(Garage.class).get();

            for (int index = 0; index < 10; index++) {
                var vehicle = garage.park(Vehicle.of(faker));
            }

           var vehicles = garage.findByTransmission(Transmission.AUTOMATIC,
                   _Vehicle.model.asc());

            System.out.println("The vehicles with" +
                    " automatic transmission are: "
             + vehicles);
            PageRequest pageRequest = PageRequest.ofSize(10);
            garage.findAll(pageRequest,_Vehicle.model.asc())
                    .forEach(System.out::println);

        }
    }

    private App() {
    }
}
