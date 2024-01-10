package humanPart;

import base.Human;
import enums.BodyType;

import java.util.Arrays;

public class Hands extends BodyPart {
    public Human hold = null;
    private BodyType handsType;

    public Hands(String name, Human owner) {
        super("руки", owner);
    }
    public void take(BodyPart part){
        System.out.println("рука "+ this.getOwner()+" взяла "+ part.getName() + " " + part.getOwner());
        hold = part.getOwner();
    }
    public void setTypes(BodyType handsType){
        this.handsType = handsType;
    }
    public BodyType getType(){
        return handsType;
    }
}
