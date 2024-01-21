package humanpart;

import base.Human;
import base.Item;

import java.util.ArrayList;

public class Hands extends BodyPart {
    public Human hold = null;
    public ArrayList<Item> holdItem = new ArrayList<>();

    public Hands(String name, Human owner) {
        super(name, owner);
    }
    public void take(BodyPart part){
        System.out.println("рука "+ this.getOwner()+" взяла "+ part.getName() + " " + part.getOwner());
        hold = part.getOwner();
    }

}
