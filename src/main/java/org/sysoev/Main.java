package org.sysoev;


import org.sysoev.task12.ReportVisitor;
import org.sysoev.task12.handler.CheckBalanceHandler;
import org.sysoev.task12.handler.CheckFraudHandler;
import org.sysoev.task12.handler.CheckStockHandler;
import org.sysoev.task12.handler.Handler;
import org.sysoev.task12.model.*;
import org.sysoev.task12.processor.OrderProcessor;
import org.sysoev.task12.processor.PhysicalOrderProcessor;
import org.sysoev.task12.visitor.PriceVisitor;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Product> items = List.of(
                new Book("best book", true, false),
                new VideoGame("best game", true, true),
                new Laptop("best laptop", false, false));

        Order order = new Order(1000.00, "user@mail.com", "Berlin", items);

        Handler stock = new CheckStockHandler();
        Handler balance = new CheckBalanceHandler();
        Handler fraud = new CheckFraudHandler();

        stock.linkWith(balance).linkWith(fraud);

        stock.handle(order);

        PriceVisitor priceVisitor = new PriceVisitor();
        ReportVisitor reportVisitor = new ReportVisitor();

        for (Product product : order.getProductList()) {
            product.accept(priceVisitor);
            product.accept(reportVisitor);
        }

        System.out.println("Total price: " + priceVisitor.getTotal());

        OrderProcessor processor = new PhysicalOrderProcessor();
        processor.processOrder(order);
    }
}