package item;

import base.Item;

public class Corpse extends Item {
    private final String corpseName;
    private Coffin coffin;
    public Corpse(String name,String corpseName){
        super(name);
        this.corpseName = corpseName;
    }
    public void setCoffin(Coffin coffin){
        this.coffin = coffin;
    }
    public String toString() {
        return corpseName;
    }
}
