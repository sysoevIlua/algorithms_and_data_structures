package org.sysoev.task10;

import java.util.ArrayList;
import java.util.List;

public class ButtonEnableModel implements Observable {

    private boolean enable = false;

    private final List<Observer> observers = new ArrayList<>();

    public boolean isEnable() {
        return enable;
    }

    public void setEnable() {
        this.enable = true;
        notifyObservers();
    }

    public void setDisable() {
        this.enable = false;
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
