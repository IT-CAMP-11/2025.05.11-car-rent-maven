package com.comarch.szkolenia.car.rent;

import com.comarch.szkolenia.car.rent.core.Core;

public class App {
    public static void main(String[] args) {
        Core.getInstance().start();
        System.out.println("conflict - master");
    }
}
