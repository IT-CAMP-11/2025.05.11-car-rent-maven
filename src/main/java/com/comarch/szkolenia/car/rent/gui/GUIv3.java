package com.comarch.szkolenia.car.rent.gui;

import com.comarch.szkolenia.car.rent.model.*;
import org.springframework.stereotype.Component;

public class GUIv3 implements IGUI {
    @Override
    public String showMenuAndReadChoose() {
        return "";
    }

    @Override
    public void showVehicles() {

    }

    @Override
    public String readPlate() {
        return "";
    }

    @Override
    public void showResult(boolean result) {

    }

    @Override
    public void showWrongChoose() {

    }

    @Override
    public User readCredentials() {
        return null;
    }

    @Override
    public void showIncorrectCredentials() {

    }

    @Override
    public String askForVehicleType() {
        return "";
    }

    @Override
    public Car readCar() {
        return null;
    }

    @Override
    public Bus readBus() {
        return null;
    }

    @Override
    public Motorcycle readMotorcycle() {
        return null;
    }

    @Override
    public void readVehicleCommonData(Vehicle vehicle) {

    }
}
