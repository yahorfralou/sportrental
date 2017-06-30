package com.epam.javadev.sportsrental.presentation.console.impl;

import com.epam.javadev.sportsrental.controller.hidden.BaseRequestController;
import com.epam.javadev.sportsrental.presentation.IMenuPresenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuPresenter implements IMenuPresenter {
    private static final String MENU_ITEM_FORMAT = "%s - %s";

    @Override
    public BaseRequestController.Action displayMenu() {
        displayMenuOptions();

        int optionChoice = inputOption();
        BaseRequestController.Action action = MenuItems.CONTROLLER_ACTIONS.get(optionChoice);
        if (action == null) {
            // TODO PANIC!
        }

        return action;
    }

    private void displayMenuOptions() {
        for (Map.Entry<Integer, String> menuItem : MenuItems.MENU_ITEMS.entrySet()) {
            outputMenuItem(menuItem.getKey(), menuItem.getValue());
        }
    }

    private void outputMenuItem(int index, String text) {
        System.out.println(String.format(MENU_ITEM_FORMAT, index, text));
    }

    private int inputOption() {
        int option = MenuItems.INDEX_EXIT;

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String optionString = scanner.next();
                try {
                    option = Integer.parseInt(optionString);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect input");
                }
            }
        } catch (Exception e) {
            System.out.println("Error occured during reading menu input " + e.toString());
        }

        return option;
    }

    private static class MenuItems {
        private static final String ITEM_LIST_ALL_PRODUCTS = "List all products";
        private static final String ITEM_SEARCH_PRODUCTS = "Search products";
        private static final String ITEM_RENT_PRODUCT = "Rent a product";
        // TODO add all items
        private static final String ITEM_EXIT = "Leave the shop";

        private static final Integer INDEX_LIST_ALL_PRODUCTS = 1;
        private static final Integer INDEX_SEARCH_PRODUCTS = 2;
        private static final Integer INDEX_RENT_PRODUCT = 3;
        // TODO add all items
        private static final Integer INDEX_EXIT = 0;

        private static final Map<Integer, String> MENU_ITEMS;
        private static final Map<Integer, BaseRequestController.Action> CONTROLLER_ACTIONS;

        static {
            MENU_ITEMS = new HashMap<>();
            initMenuItemsMap();

            CONTROLLER_ACTIONS = new HashMap<>();
            initActionsMap();

        }

        private static void initMenuItemsMap() {

            MENU_ITEMS.put(INDEX_LIST_ALL_PRODUCTS, ITEM_LIST_ALL_PRODUCTS);
            MENU_ITEMS.put(INDEX_SEARCH_PRODUCTS, ITEM_SEARCH_PRODUCTS);
            MENU_ITEMS.put(INDEX_RENT_PRODUCT, ITEM_RENT_PRODUCT);
            MENU_ITEMS.put(INDEX_EXIT, ITEM_EXIT);
        }

        private static void initActionsMap() {
            CONTROLLER_ACTIONS.put(INDEX_LIST_ALL_PRODUCTS, BaseRequestController.Action.LIST_PRODUCTS);
            CONTROLLER_ACTIONS.put(INDEX_SEARCH_PRODUCTS, BaseRequestController.Action.SEARCH_PRODUCTS);
            CONTROLLER_ACTIONS.put(INDEX_RENT_PRODUCT, BaseRequestController.Action.RENT_PRODUCT);
            CONTROLLER_ACTIONS.put(INDEX_EXIT, BaseRequestController.Action.EXIT);
        }
    }
}
