package com.comarch.szkolenia.car.rent.core;

import com.comarch.szkolenia.car.rent.authentication.Authenticator;
import com.comarch.szkolenia.car.rent.authentication.IAuthenticator;
import com.comarch.szkolenia.car.rent.database.IUserRepository;
import com.comarch.szkolenia.car.rent.database.IVehicleRepository;
import com.comarch.szkolenia.car.rent.exceptions.FailedAuthenticationException;
import com.comarch.szkolenia.car.rent.exceptions.RentVehicleException;
import com.comarch.szkolenia.car.rent.gui.IGUI;
import com.comarch.szkolenia.car.rent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Core implements ICore {
    @Autowired
    private IVehicleRepository vehicleRepository;
    @Autowired
    private IAuthenticator authenticator;
    @Autowired
    private IGUI gui;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void start() {
        boolean run = authenticateUser();
        while(run) {
            switch(this.gui.showMenuAndReadChoose()) {
                case "1":
                    this.gui.showVehicles();
                    break;
                case "2":
                    if(Authenticator.currentUserRole == User.Role.ADMIN) {
                        addVehicle();
                    } else {
                        try {
                            this.vehicleRepository.rentVehicle(this.gui.readPlate());
                            this.gui.showResult(true);
                        } catch (RentVehicleException e) {
                            this.gui.showResult(false);
                        }
                    }
                    break;
                case "3":
                    run = authenticateUser();
                    break;
                case "4":
                    run = false;
                    this.vehicleRepository.persist();
                    this.userRepository.persist();
                    break;
                default:
                    this.gui.showWrongChoose();
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
