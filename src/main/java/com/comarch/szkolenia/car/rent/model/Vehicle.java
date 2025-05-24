package com.comarch.szkolenia.car.rent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double price;
    private boolean rent;
    private String plate;

    public Vehicle(String brand, String model, int year, double price, String plate) {
        this(brand, model, year, price, false, plate);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getBrand())
                .append(" ")
                .append(this.getModel())
                .append(" Year: ")
                .append(this.getYear())
                .append(" Price: ")
                .append(this.getPrice())
                .append("zl Plate: ")
                .append(this.getPlate())
                .append(this.isRent() ? " Not available" : " Available")
                .toString();
    }

    public String convertToDatabaseLine() {
        return String.join(";", this.brand, this.model, this.year+"",
                this.price+"", this.rent+"", this.plate);
    }
}
