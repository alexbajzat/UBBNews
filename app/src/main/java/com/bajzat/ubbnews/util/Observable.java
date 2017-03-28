package com.bajzat.ubbnews.util;

/**
 * Created by bjz on 3/25/2017.
 */

public interface Observable {
    void addObserver(Observer obs);
    void notifyObservers();
}
