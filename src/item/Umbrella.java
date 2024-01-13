package item;

import base.Human;
import base.Item;
import enums.Color;
import enums.ItemType;
import java.util.Arrays;

public class Umbrella extends Item {
    private Color color;
    public Umbrella(String name, Color color, ItemType... types){
        super(name);
        this.color = color;
        this.types.addAll(Arrays.asList(types));
    }
    @Override
    public Color getColor() {
        return color;
    }
    public String toString(){
        return name;
    }
}

