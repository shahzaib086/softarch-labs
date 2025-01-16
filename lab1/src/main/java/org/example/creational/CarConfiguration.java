package org.example.creational;

import org.example.creational.builder.Car;

public class CarConfiguration {

    public static void main(String[] args) {
        // TODO: Create and configure different cars using the Builder pattern

//        Car car1 = new Car....
//        System.out.println(car1);
    
        Car car1 = new Car.Builder()
                .setEngine("V6")
                .setTransmission("Automatic")
                .setInterior("Leather seats")
                .setColor("Red")
                .setSunroof(true)
                .setGPS(true)
                .setSafetyPackage(true)
                .build();

        System.out.println(car1);

        Car car2 = new Car.Builder()
                .setEngine("V8")
                .setTransmission("Manual")
                .setInterior("Cloth seats")
                .setColor("Blue")
                .setSunroof(false)
                .setGPS(false)
                .setSafetyPackage(true)
                .build();

        System.out.println(car2);

    }
}
