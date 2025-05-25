package com.comarch.szkolenia.car.rent.gui;

import com.comarch.szkolenia.car.rent.model.*;

public interface IGUI {
    String showMenuAndReadChoose();
    void showVehicles();
    String readPlate();
    void showResult(boolean result);
    void showWrongChoose();
    User readCredentials();
    void showIncorrectCredentials();
    String askForVehicleType();
    Car readCar();
    Bus readBus();
    Motorcycle readMotorcycle();
    void readVehicleCommonData(Vehicle vehicle);
}
