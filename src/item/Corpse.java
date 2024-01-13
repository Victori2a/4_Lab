package item;

import base.Human;
import base.Item;
import enums.Color;

public class Corpse extends Item {
    private String corpseName;
    public Corpse(String name,String corpseName){
        super(name);
        this.corpseName = corpseName;
    }
    public String toString() {
        return corpseName;
    }
}
