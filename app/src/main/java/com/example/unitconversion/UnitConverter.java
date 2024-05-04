package com.example.unitconversion;

public class UnitConverter {
    public static double poundToKilogram(double pound) {
        return pound * 0.453592;
    }

    public static double kilogramToPound(double kilogram) {
        return kilogram * 2.20462;
    }

    public static double mileToKilometer(double mile) {
        return mile * 1.60934;
    }

    public static double kilometerToMile(double kilometer) {
        return kilometer * 0.621371;
    }
}
