package org.sysoev.task12.model;

import org.sysoev.task12.visitor.Visitor;

public class Laptop extends Product{

    private static final double PRICE = 100;

    public Laptop(String productName, boolean inStock, boolean isSuspicious) {
        super(productName, PRICE, inStock, isSuspicious);
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitLaptop(this);
    }
}
