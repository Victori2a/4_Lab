package item;

import base.Human;
import enums.HumanType;
import base.Item;
import enums.Color;

public class Cigarette extends Item {
    private boolean suitable = false;
    public Cigarette(String name) {
        super(name);
    }
    public void goOut(){
        this.suitable = false;
    }
    public void lit(){
        this.suitable = true;
    }
}
