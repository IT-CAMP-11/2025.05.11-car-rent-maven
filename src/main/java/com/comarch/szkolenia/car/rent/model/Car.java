package com.comarch.szkolenia.car.rent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
public class Car extends Vehicle {
    public Car(String brand, String model, int year, double price, String plate) {
        super(brand, model, year, price, plate);
    }

    public Car(String brand, String model, int year, double price, boolean rent, String plate) {
        super(brand, model, year, price, rent, plate);
    }

    @Override
    public String convertToDatabaseLine() {
        return "Car;" + super.convertToDatabaseLine();
    }
}
