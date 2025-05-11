package com.comarch.szkolenia.car.rent.core;

import com.comarch.szkolenia.car.rent.authentication.Authenticator;
import com.comarch.szkolenia.car.rent.database.VehicleRepository;
import com.comarch.szkolenia.car.rent.exceptions.FailedAuthenticationException;
import com.comarch.szkolenia.car.rent.exceptions.RentVehicleException;
import com.comarch.szkolenia.car.rent.gui.GUI;
import com.comarch.szkolenia.car.rent.model.User;
import lombok.Getter;

public class Core {
    private final VehicleRepository vehicleRepository = VehicleRepository.getInstance();
    private final Authenticator authenticator = Authenticator.getInstance();
    private final GUI gui = GUI.getInstance();
    @Getter
    private final static Core instance = new Core();

    private Core() {
    }

    public void start() {
        boolean run = authenticateUser();
        while(run) {
            switch(gui.showMenuAndReadChoose()) {
                case "1":
                    gui.showVehicles();
                    break;
                case "2":
                    if(Authenticator.currentUserRole == User.Role.ADMIN) {
                        addVehicle();
                    } else {
                        try {
                            vehicleRepository.rentVehicle(gui.readPlate());
                            gui.showResult(true);
                        } catch (RentVehicleException e) {
                            gui.showResult(false);
                        }
                    }
                    break;
                case "3":
                    run = authenticateUser();
                    break;
                case "4":
                    run = false;
                    break;
                default:
                    gui.showWrongChoose();
                    break;
            }
        }
    }

    private boolean authenticateUser() {
        boolean result;
        int counter = 0;
        do {
            User user = gui.readCredentials();
            try {
                authenticator.authenticate(user.getLogin(), user.getPassword());
                result = true;
            } catch (FailedAuthenticationException e) {
                result = false;
                gui.showIncorrectCredentials();
            }
            counter++;
        } while(!result && counter < 3);

        return result;
    }

    private void addVehicle() {
        switch (gui.askForVehicleType()) {
            case "C":
                vehicleRepository.addVehicle(gui.readCar());
                break;
            case "B":
                vehicleRepository.addVehicle(gui.readBus());
                break;
            case "M":
                vehicleRepository.addVehicle(gui.readMotorcycle());
                break;
            default:
                gui.showWrongChoose();
                break;
        }
    }
}
