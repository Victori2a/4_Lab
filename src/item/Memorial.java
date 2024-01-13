package item;

import base.Human;
import base.Item;
import base.Position;
import enums.Color;
import enums.ItemType;

public class Memorial extends Item implements Position {
    String surname;
    public Memorial(String name,String surname, ItemType... type){
        super(name);
        this.surname = surname;
        setType(type);
    }
    public String toString() {
        return name+" c фамилией "+surname;
    }
    @Override
    public void addPosition(Human human) {
        human.addPos(this);
    }
    @Override
    public void addPosition(Item item) {
       item.addPos(this);
    }
}
