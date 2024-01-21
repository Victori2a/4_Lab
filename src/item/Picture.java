package item;

import base.Item;

public class Picture extends Item {
    String object;
    public Picture(String name, Item item) {
        super(name);
        this.object = item.toString();
    }
    @Override
    public String toString(){
       return name + ", на котором изображён "+ object;
    }
}
