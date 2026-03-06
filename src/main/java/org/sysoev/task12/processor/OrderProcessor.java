package org.sysoev.task12.processor;

import org.sysoev.task12.model.Order;

public abstract class OrderProcessor {

    public final void processOrder(Order order)
    {
        validate(order);
        calculatePrice(order);
        pay(order);
    }

    public abstract void validate(Order order);
    public abstract double calculatePrice(Order order);
    public abstract void pay(Order order);

    public void notification() {}
}
