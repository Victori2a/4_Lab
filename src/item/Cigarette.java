package item;

import base.Item;

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
    public boolean isSuitable(){
        return suitable;
    }
}
