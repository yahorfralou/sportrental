package com.epam.javadev.sportsrental;

import com.epam.javadev.sportsrental.controller.StartUpController;
import com.epam.javadev.sportsrental.controller.hidden.BaseRequestController;

/**
 * Created by Yahor_Fralou on 6/21/2017.
 */
public class Main {

    public static void main(String... args) {
        StartUpController startUpController = new StartUpController();

        startUpController.doOnStartUp();

        BaseRequestController baseRequestController = new BaseRequestController();

        baseRequestController.startApplication();
    }
}