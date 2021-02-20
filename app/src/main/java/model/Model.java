package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable  {
    private String data = "";
    ArrayList<Observer> observers = new ArrayList<>();




    public String getData() {
        return data;
    }

    public void setData(String data) {

        this.data = data;
        setChanged();
        notifyObservers();
    }



}
