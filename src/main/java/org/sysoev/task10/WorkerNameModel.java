package org.sysoev.task10;

import java.util.ArrayList;
import java.util.List;


public class WorkerNameModel implements Observable {

    private String workerName;


    private final List<Observer> observers = new ArrayList<>();

    public String getWorkerName() {
        return workerName;
    }


    public void changeWorkerName(String text) {
        this.workerName = text;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}
