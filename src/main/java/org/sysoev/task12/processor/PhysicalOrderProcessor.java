package org.sysoev.task12.processor;

import org.sysoev.task12.model.Order;
import org.sysoev.task12.model.PaymentType;

public class PhysicalOrderProcessor extends OrderProcessor {

    private static final double DELIVERY_PRICE = 219.00;

    @Override
    public void validate(Order order) {
        if (order.getAddress().isBlank() || order.getAddress() == null) {
            System.out.println("Address is null or empty");
        }
        System.out.println("Validating is successful");
    }

    @Override
    public double calculatePrice(Order order) {

        double price = order.getPrice() + DELIVERY_PRICE;

        System.out.println("Price on Physical process is " + order.getPrice());
        return price;
    }

    @Override
    public void pay(Order order) {
        order.setPaymentType(PaymentType.OFFLINE);
        System.out.println("Order has been paid offline");
    }
}
