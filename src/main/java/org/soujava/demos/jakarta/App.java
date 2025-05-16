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


import jakarta.data.Order;
import jakarta.data.page.PageRequest;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import net.datafaker.Faker;

import java.util.logging.Logger;


//define vehicle entity
//basic operation with repository
//find queries
//bult in vs classic repositories
//pagination (two types)

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        var faker = new Faker();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            var repository = container.select(Garage.class).get();

            for (int index = 0; index < 10; index++) {
                var vehicle = Vehicle.of(faker);
                repository.parking(vehicle);
            }

            PageRequest pageRequest = PageRequest.ofSize(2);
            var page = repository.findAll(pageRequest);
            LOGGER.info(() -> "Page: " + page.content());
            PageRequest page2 = page.nextPageRequest();
            var page2Result = repository.findAll(page2);
            LOGGER.info(() -> "Page2: " + page2Result.content());

        }
    }

    private App() {
    }
}
