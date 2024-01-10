package item;

import base.Item;
import interfaces.AbleToStore;

import java.util.ArrayList;
import java.util.Arrays;

public class Rack extends Item implements AbleToStore {
    String name = "стойка";
    private ArrayList<Item> umbrellas= new ArrayList<>();

    @Override
    public void setItems(Item... items) {
        this.umbrellas.addAll(Arrays.asList(items));
    }
    public String toString(){
        return name;
    }
}
