package com.comarch.szkolenia.car.rent;

import com.comarch.szkolenia.car.rent.model.Bus;
import com.comarch.szkolenia.car.rent.model.Car;
import com.comarch.szkolenia.car.rent.model.Motorcycle;

public class Test {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2020, 300.00, "KR1");
        System.out.println(car.convertToDatabaseLine());

        Motorcycle motorcycle = new Motorcycle("Honda", "Jakas", 2020,
                200.00, "KR999", true);
        System.out.println(motorcycle.convertToDatabaseLine());

        System.out.println(Bus.class.getSimpleName());
    }
}
