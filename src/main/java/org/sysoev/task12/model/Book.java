package org.sysoev.task12.model;

import org.sysoev.task12.visitor.Visitor;

public class Book extends Product{

    private static final double PRICE = 20;

    public Book(String productName, boolean inStock, boolean isSuspicious) {
        super(productName, PRICE, inStock, isSuspicious);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
    }
}
