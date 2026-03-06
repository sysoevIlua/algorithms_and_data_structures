package org.sysoev.task12;

import org.sysoev.task12.model.Book;
import org.sysoev.task12.model.Laptop;
import org.sysoev.task12.model.VideoGame;
import org.sysoev.task12.visitor.Visitor;

public class ReportVisitor implements Visitor {
    @Override
    public void visitBook(Book book) {
        System.out.println("Book processed "+book.getProductName());
    }

    @Override
    public void visitVideoGame(VideoGame game) {
        System.out.println("VideoGame processed "+game.getProductName());
    }

    @Override
    public void visitLaptop(Laptop laptop) {
        System.out.println("Laptop processed "+laptop.getProductName());
    }
}
