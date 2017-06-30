package com.epam.javadev.sportsrental.controller.hidden.action;

import com.epam.javadev.sportsrental.controller.hidden.BaseRequestController;
import com.sun.istack.internal.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yahor_Fralou on 6/27/2017.
 */
public class ActionFactory {
    private static IActionController listProductsAction = new ListProductsAction();
    private static final Map<BaseRequestController.Action, IActionController> ACTIONS;

    static {
        ACTIONS = new HashMap<>();
        ACTIONS.put(BaseRequestController.Action.LIST_PRODUCTS, listProductsAction);
    }

    @Nullable
    public static IActionController getActionController(BaseRequestController.Action action) {
        return ACTIONS.get(action);
    }

}
