package item;

import base.Item;
import enums.Condition;

public class Picture extends Item {
    Corpse corpse;
    public Picture(String name, Corpse corpse) {
        super(name);
        this.corpse = corpse;
    }

    public String toString(){
       return name;
    }
}
