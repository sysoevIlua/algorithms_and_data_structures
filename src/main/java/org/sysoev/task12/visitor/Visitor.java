package org.sysoev.task12.visitor;

import org.sysoev.task12.model.Book;
import org.sysoev.task12.model.Laptop;
import org.sysoev.task12.model.VideoGame;

public interface Visitor {
    void visitBook(Book book);
    void visitVideoGame(VideoGame game);
    void visitLaptop(Laptop laptop);
}
