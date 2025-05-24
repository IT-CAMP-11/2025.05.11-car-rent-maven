package com.comarch.szkolenia.car.rent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Motorcycle extends Vehicle {
    private boolean additionalSeat;

    public Motorcycle(String brand, String model, int year, double price, String plate, boolean additionalSeat) {
        super(brand, model, year, price, plate);
        this.additionalSeat = additionalSeat;
    }

    public Motorcycle(String brand, String model, int year, double price, boolean rent, String plate, boolean additionalSeat) {
        super(brand, model, year, price, rent, plate);
        this.additionalSeat = additionalSeat;
    }

    @Override
    public String toString() {
        return super.toString() + " Additional seat: " + this.additionalSeat;
    }

    @Override
    public String convertToDatabaseLine() {
        return "Motorcycle;" + super.convertToDatabaseLine() + ";" + this.additionalSeat;
    }
}
