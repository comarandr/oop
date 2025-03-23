package it.uniud.poo.trasporti_2024;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableImpl implements Observable {

    protected List<Observer> observers=new ArrayList<Observer>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

}
