package org.sysoev.task12.handler;

import org.sysoev.task12.model.Order;
import org.sysoev.task12.model.Product;

public class CheckStockHandler extends Handler{
    @Override
    protected boolean check(Order order) {
        for (Product product: order.getProductList()){
            if (!product.isInStock()){
                System.out.println("Product "+product+" is not in stock");
                return false;
            }
        }
        System.out.println("Stock check passed");
        return true;
    }
}
