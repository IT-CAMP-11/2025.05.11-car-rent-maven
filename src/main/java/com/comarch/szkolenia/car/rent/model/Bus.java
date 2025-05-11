package com.comarch.szkolenia.car.rent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bus extends Vehicle {
    private int seats;

    public Bus(String brand, String model, int year, double price, String plate, int seats) {
        super(brand, model, year, price, plate);
        this.seats = seats;
    }

    @Override
    public String toString() {
        return super.toString() + " Seats: " + this.seats;
    }
}