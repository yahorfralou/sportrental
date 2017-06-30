package com.epam.javadev.sportsrental.controller.hidden;

import com.epam.javadev.sportsrental.controller.hidden.action.ActionFactory;
import com.epam.javadev.sportsrental.controller.hidden.action.IActionController;
import com.epam.javadev.sportsrental.presentation.IMenuPresenter;
import com.epam.javadev.sportsrental.presentation.console.impl.MenuPresenter;

public class BaseRequestController {

    public void startApplication() {
        Action action = displayMenu();

        while (action != Action.EXIT) {
            executeCommand(action);

            action = displayMenu();
        }

    }

    private Action displayMenu() {
        // TODO make a factory call
        IMenuPresenter menuPresenter = new MenuPresenter();

        return menuPresenter.displayMenu();
    }

    private void executeCommand(Action action) {
        IActionController actionController = ActionFactory.getActionController(action);
        //if (actionController == null) {}
        actionController.execute();
    }

    public enum Action {
        LIST_PRODUCTS, RENT_PRODUCT, SEARCH_PRODUCTS, EXIT
    }
}
