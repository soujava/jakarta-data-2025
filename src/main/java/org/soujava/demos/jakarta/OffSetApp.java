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


import jakarta.data.page.PageRequest;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import net.datafaker.Faker;


public class OffSetApp {


    public static void main(String[] args) {
        var faker = new Faker();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            var garage = container.select(Garage.class).get();

            for (int index = 0; index < 10; index++) {
                garage.park(Vehicle.of(faker));
            }

            var page = garage.offset(Transmission.AUTOMATIC, PageRequest.ofSize(3));

            System.out.println("the offset page content: " + page.content());
            var page2 = garage.offset(Transmission.AUTOMATIC, page.nextPageRequest());
            System.out.println("the offset2 page content: " + page2.content());

        }
    }

    private OffSetApp() {
    }
}
