package org.sysoev.task12.model;

import java.util.List;

public class Order {
    private double price;
    private double balance;
    private String email;
    private String address;
    private PaymentType paymentType;
    private List<Product> productList;

    public Order(double balance, String email, String address, List<Product> productList) {
        this.balance = balance;
        this.email = email;
        this.address = address;
        this.productList = productList;

        double price = 0;
        for (Product product : this.getProductList()) {
            price = price + product.getPrice();
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
