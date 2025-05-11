package com.comarch.szkolenia.car.rent.gui;

import com.comarch.szkolenia.car.rent.authentication.Authenticator;
import com.comarch.szkolenia.car.rent.database.VehicleRepository;
import com.comarch.szkolenia.car.rent.model.*;
import lombok.Getter;

import java.util.Scanner;

public class GUI {
    private final Scanner scanner = new Scanner(System.in);
    private final VehicleRepository vehicleRepository = VehicleRepository.getInstance();
    @Getter
    private final static GUI instance = new GUI();

    private GUI() {
    }

    public String showMenuAndReadChoose() {
        System.out.println("1. List vehicles");
        System.out.println(Authenticator.currentUserRole == User.Role.ADMIN ?
                "2. Add vehicle" : "2. Rent vehicle");
        System.out.println("3. Logout");
        System.out.println("4. Exit");

        return scanner.nextLine();
    }

    public void showVehicles() {
        for(Vehicle vehicle : this.vehicleRepository.getVehicles()) {
            System.out.println(vehicle);
        }
    }

    public String readPlate() {
        System.out.println("Enter plate:");
        return scanner.nextLine();
    }

    public void showResult(boolean result) {
        System.out.println(result ? "Success !!" : "Error !!");
    }

    public void showWrongChoose() {
        System.out.println("Wrong choose !! Pick again !!");
    }

    public User readCredentials() {
        System.out.println("Enter login:");
        String login = scanner.nextLine();
        System.out.println("Enter password:");
        return new User(login, scanner.nextLine());
    }

    public void showIncorrectCredentials() {
        System.out.println("Incorrect credentials");
    }

    public String askForVehicleType() {
        System.out.println("Select vehicle type: (C/B/M)");
        return scanner.nextLine();
    }

    public Car readCar() {
        Car car = new Car();
        readVehicleCommonData(car);
        return car;
    }

    public Bus readBus() {
        Bus bus = new Bus();
        readVehicleCommonData(bus);
        System.out.println("Seats:");
        bus.setSeats(Integer.parseInt(scanner.nextLine()));
        return bus;
    }

    public Motorcycle readMotorcycle() {
        Motorcycle motorcycle = new Motorcycle();
        readVehicleCommonData(motorcycle);
        System.out.println("Additional seat: (Y/N)");
        motorcycle.setAdditionalSeat(scanner.nextLine().equals("Y"));
        return motorcycle;
    }

    public void readVehicleCommonData(Vehicle vehicle) {
        System.out.println("Brand:");
        vehicle.setBrand(scanner.nextLine());
        System.out.println("Model:");
        vehicle.setModel(scanner.nextLine());
        System.out.println("Year:");
        vehicle.setYear(Integer.parseInt(scanner.nextLine()));
        System.out.println("Price:");
        vehicle.setPrice(Double.parseDouble(scanner.nextLine()));
        System.out.println("Plate:");
        vehicle.setPlate(scanner.nextLine());
    }
}
