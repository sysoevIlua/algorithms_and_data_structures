package org.sysoev.task12.handler;

import org.sysoev.task12.model.Order;
import org.sysoev.task12.model.Product;

public class CheckFraudHandler extends Handler{
    @Override
    protected boolean check(Order order) {
        for(Product product : order.getProductList()){
            if(product.isSuspicious()) {
                System.out.println("Suspicious product: "  + product);
                return  false;
            }
        }
        System.out.println("Order check passed");
        return true;
    }
}
