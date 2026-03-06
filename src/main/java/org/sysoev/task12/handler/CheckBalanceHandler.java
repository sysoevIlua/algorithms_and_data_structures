package org.sysoev.task12.handler;

import org.sysoev.task12.model.Order;

public class CheckBalanceHandler extends Handler{
    @Override
    protected boolean check(Order order) {
        if (order.getPrice() > order.getBalance()) {
            System.out.println("Insufficient balance");
            return false;
        }
        System.out.println("Order check passed");
        return true;
    }
}
