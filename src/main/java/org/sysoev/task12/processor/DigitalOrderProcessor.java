package org.sysoev.task12.processor;

import org.sysoev.task12.model.Order;
import org.sysoev.task12.model.PaymentType;

public class DigitalOrderProcessor extends OrderProcessor {
    @Override
    public void validate(Order order) {
        if (order.getEmail().isBlank() || order.getEmail() == null) {
            System.out.println("Email is null or empty");
        }
        System.out.println("Validating is successful");
    }

    @Override
    public double calculatePrice(Order order) {
        System.out.println("Price on Digital process is " + order.getPrice());
        return order.getPrice();
    }

    @Override
    public void pay(Order order) {
        order.setPaymentType(PaymentType.ONLINE);
        System.out.println("Order has been paid online");
    }
}
