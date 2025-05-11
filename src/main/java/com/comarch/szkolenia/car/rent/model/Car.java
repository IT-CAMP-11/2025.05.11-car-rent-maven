package com.comarch.szkolenia.car.rent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
public class Car extends Vehicle {
    public Car(String brand, String model, int year, double price, String plate) {
        super(brand, model, year, price, plate);
    }
}
