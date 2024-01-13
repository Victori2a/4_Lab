package humanPart;

import base.Human;
import enums.HairType;

import java.util.ArrayList;
import java.util.Arrays;

public class Hair extends BodyPart{
    public double stylishLook = 15;
    protected ArrayList<HairType> hairTypes = new ArrayList<>();
    public Hair(String name, Human owner) {
        super(name, owner);
    }
    public void setTypes(HairType... faceTypes){
        hairTypes.addAll(Arrays.asList(faceTypes));
    }
    public HairType[] getTypes() {
        HairType[] types1 = new HairType[this.hairTypes.size()];
        return this.hairTypes.toArray(types1);
    }
    public void disheveled(){
        System.out.println(getName() + " спутались. Ухоженность волос "+getOwner()+": " + stylishLook);
    }

}