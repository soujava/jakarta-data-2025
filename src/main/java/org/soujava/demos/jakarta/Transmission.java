package org.soujava.demos.jakarta;

public enum Transmission {
    AUTOMATIC, MANUAL;


    public static Transmission of(String value) {
        if (value == null) {
            return null;
        }
        return value.equalsIgnoreCase("automatic") ? AUTOMATIC : MANUAL;
    }
}
