package org.sysoev.task12.model;

import org.sysoev.task12.visitor.Visitor;

public abstract class Product {

    String productName;
    double price;
    boolean inStock;
    boolean isSuspicious;

    Product(String productName, double price, boolean inStock, boolean isSuspicious) {
        this.productName = productName;
        this.price = price;
        this.inStock = inStock;
        this.isSuspicious = isSuspicious;
    }

    public abstract void accept(Visitor visitor);

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public boolean isSuspicious() {
        return isSuspicious;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setInStock(boolean inStock){
        this.inStock = inStock;
    }

    public void setSuspicious(boolean suspicious){
        this.isSuspicious = suspicious;
    }
}
