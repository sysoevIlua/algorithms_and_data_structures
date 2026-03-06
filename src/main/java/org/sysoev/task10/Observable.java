package org.sysoev.task10;


public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers();
}
