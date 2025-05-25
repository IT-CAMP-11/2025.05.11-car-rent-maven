package com.comarch.szkolenia.car.rent.database;

import com.comarch.szkolenia.car.rent.model.Vehicle;

import java.util.Collection;

public interface IVehicleRepository {
    void rentVehicle(String plate);
    void addVehicle(Vehicle vehicle);
    Collection<Vehicle> getVehicles();
    void persist();
}
