package item;

import base.Item;
import base.Position;
import enums.Color;

public class Coffin extends Item {
    private final Corpse owner;
    private final Color color;
    private final Grave grave;
    public Coffin(String name, Corpse owner, Color color, Grave grave){
        super(name);
        this.color=color;
        this.grave = grave;
        this. owner=owner;
        assignCoffin(owner);
    }

    private void assignCoffin(Corpse owner) {
        owner.setCoffin(this);
    }

    public Corpse getOwner(){
        return this.owner;
    }
    @Override
    public void stand(Position position) {
        super.stand(position);
        if (this.getColor() == Color.WHITE) {
            System.out.println(getColor() + " " + this + " " + this.getOwner() + "а стоял над прокладкой на двух хромированных подставках");
        }
    }
    public Color getColor() {
        return color;
    }
    @Override
    public String toString() {
        return name;
    }
}
