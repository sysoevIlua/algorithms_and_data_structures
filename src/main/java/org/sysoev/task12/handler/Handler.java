package org.sysoev.task12.handler;

import org.sysoev.task12.model.Order;

public abstract class Handler {
    private Handler next;

    public Handler() {}

    public Handler linkWith(Handler next) {
        this.next = next;
        return next;
    }

    public void handle(Order order) {
        if (check(order)) {
            if (next != null) {
                next.handle(order);
            }
        } else {
            System.out.println("Order rejected");
        }
    }

    protected abstract boolean check(Order order);
}
