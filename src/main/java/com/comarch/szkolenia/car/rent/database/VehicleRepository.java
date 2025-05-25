package com.comarch.szkolenia.car.rent.database;

import com.comarch.szkolenia.car.rent.exceptions.RentVehicleException;
import com.comarch.szkolenia.car.rent.model.Bus;
import com.comarch.szkolenia.car.rent.model.Car;
import com.comarch.szkolenia.car.rent.model.Motorcycle;
import com.comarch.szkolenia.car.rent.model.Vehicle;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class VehicleRepository implements IVehicleRepository {
    private final Map<String, Vehicle> vehicles;
    private final String DB_FILE = "vehicles.txt";

    public VehicleRepository() {
        this.vehicles = new HashMap<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(DB_FILE))) {
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                String[] parameters = line.split(";");
                Vehicle vehicle;
                switch (parameters[0]) {
                    case "Bus":
                        vehicle = new Bus(parameters[1], parameters[2], Integer.parseInt(parameters[3]),
                                Double.parseDouble(parameters[4]), Boolean.parseBoolean(parameters[5]),
                                parameters[6], Integer.parseInt(parameters[7]));
                        break;
                    case "Car":
                        vehicle = new Car(parameters[1], parameters[2], Integer.parseInt(parameters[3]),
                                Double.parseDouble(parameters[4]), Boolean.parseBoolean(parameters[5]),
                                parameters[6]);
                        break;
                    case "Motorcycle":
                        vehicle = new Motorcycle(parameters[1], parameters[2], Integer.parseInt(parameters[3]),
                                Double.parseDouble(parameters[4]), Boolean.parseBoolean(parameters[5]),
                                parameters[6], Boolean.parseBoolean(parameters[7]));
                        break;
                    default:
                        System.out.println("Unknown vehicle type: " + line);
                        continue;
                }
                this.vehicles.put(vehicle.getPlate(), vehicle);
            }
        } catch (IOException e) {
            System.out.println("Nie dziala plik !!");
        }
    }

    @Override
    public void rentVehicle(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);

        if(vehicle == null || vehicle.isRent()) {
            throw new RentVehicleException();
        }

        vehicle.setRent(true);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.put(vehicle.getPlate(), vehicle);
    }

    @Override
    public Collection<Vehicle> getVehicles() {
        return this.vehicles.values();
    }

    @Override
    public void persist() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(DB_FILE))) {
            for(Vehicle v : getVehicles()) {
                writer.write(v.convertToDatabaseLine());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Nie dziala zapisywanie !!");
        }
    }
}
