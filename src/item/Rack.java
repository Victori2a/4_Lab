package item;

import base.Item;
import interfaces.AbleToStore;

import java.util.ArrayList;
import java.util.Arrays;

public class Rack extends Item implements AbleToStore {
    private ArrayList<Item> umbrellas= new ArrayList<>();
    public Rack(String name) {
        super(name);
    }
    @Override
    public void setItems(Item... items) {
        this.umbrellas.addAll(Arrays.asList(items));
    }
    @Override
    public String getWhere() {
        return "стойку";
    }
    public String toString(){
        return name;
    }
}
