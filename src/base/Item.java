package base;

import enums.Color;
import enums.ItemType;
import interfaces.HasLocation;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Item implements HasLocation {
    protected String name;
    protected Location location;
    protected Position position;
    protected ArrayList<ItemType> types = new ArrayList<>();
    public Item(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public Color getColor() {
        return null;
    }
    public void setType(ItemType... types) {
        this.types.addAll(Arrays.asList(types));
    }
    public boolean hasType(ItemType type) {
        return this.types.contains(type);
    }
    @Override
    public void setLocation(Location location) {
        location.addItem(this);
        this.location = location;
    }
    public Location getLocation(){
        return location;
    }
    public void addPos(Position position){
        this.position = position;
    }
    public void stand(Position position){
        position.addPosition(this);
    }

}
