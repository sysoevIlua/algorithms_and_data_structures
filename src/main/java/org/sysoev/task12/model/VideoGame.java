package org.sysoev.task12.model;

import org.sysoev.task12.visitor.Visitor;

public class VideoGame extends Product{

    private static final double PRICE = 30;

    public VideoGame(String productName, boolean inStock, boolean isSuspicious) {
        super(productName, PRICE, inStock, isSuspicious);
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitVideoGame(this);
    }
}
