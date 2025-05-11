package com.comarch.szkolenia.car.rent.database;

import com.comarch.szkolenia.car.rent.exceptions.RentVehicleException;
import com.comarch.szkolenia.car.rent.model.Bus;
import com.comarch.szkolenia.car.rent.model.Car;
import com.comarch.szkolenia.car.rent.model.Motorcycle;
import com.comarch.szkolenia.car.rent.model.Vehicle;
import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private final Map<String, Vehicle> vehicles;
    @Getter
    private final static VehicleRepository instance = new VehicleRepository();

    private VehicleRepository() {
        this.vehicles = new HashMap<>();
        this.vehicles.put("KR1", new Car("Toyota", "Corolla", 2020, 300.00, "KR1"));
        this.vehicles.put("KR2", new Car("Kia", "Ceed", 2021, 320.00, "KR2"));
        this.vehicles.put("KR3", new Car("BMW", "3", 2019, 350.00, "KR3"));
        this.vehicles.put("KR4", new Car("Fiat", "Panda", 2015, 100.00, "KR4"));
        this.vehicles.put("KR5", new Car("Honda", "Civic", 2022, 400.00, "KR5"));
        this.vehicles.put("KR66",
                new Bus("Mercedess", "1000", 2000, 500.0, "KR66", 50));
        this.vehicles.put("KR77",
                new Bus("Urbino", "2000", 2015, 700.00, "KR77", 55));
        this.vehicles.put("KR88",
                new Bus("Mercedess", "2000", 2020, 900.00, "KR88", 62));
        this.vehicles.put("KR999",
                new Motorcycle("Honda", "Jakas", 2020,
                        200.00, "KR999", true));
    }

    public void rentVehicle(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);

        if(vehicle == null || vehicle.isRent()) {
            throw new RentVehicleException();
        }

        vehicle.setRent(true);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.put(vehicle.getPlate(), vehicle);
    }

    public Collection<Vehicle> getVehicles() {
        return this.vehicles.values();
    }
}
