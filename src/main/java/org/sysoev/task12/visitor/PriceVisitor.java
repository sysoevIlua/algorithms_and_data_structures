package org.sysoev.task12.visitor;

import org.sysoev.task12.model.Book;
import org.sysoev.task12.model.Laptop;
import org.sysoev.task12.model.VideoGame;

public class PriceVisitor implements Visitor {

    double total = 0;

    @Override
    public void visitBook(Book book) {
        total += book.getPrice();
    }

    @Override
    public void visitVideoGame(VideoGame game) {
        total += game.getPrice();
    }

    @Override
    public void visitLaptop(Laptop laptop) {
        total += laptop.getPrice();
    }

    public double getTotal() {
        return total;
    }
}