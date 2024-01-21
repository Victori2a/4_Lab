package humanpart;

import base.Human;
import enums.HumanType;

public class Eyes extends BodyPart{
    private double clarity = 1.0;
    public Eyes(String name, Human owner) {
        super(name, owner);
    }
    public void setClarity(double var){
        this.clarity += var;
    }
    public void act(Human human) {
        System.out.println(getName()+" "+human + " сщурились из-за яркости" );
        human.setTypes(HumanType.BLINDED);
        human.removeType(HumanType.BLINDED);
    }
}
