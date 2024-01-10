package humanPart;

import base.Human;
import enums.BodyType;
import enums.HumanType;

import java.util.ArrayList;
import java.util.Arrays;

public class Mouth extends BodyPart{
    protected ArrayList<BodyType> mouthType = new ArrayList<>();
    public Mouth(String name, Human owner) {
        super("рот", owner);
    }
    public void setTypes(BodyType... faceTypes){
        mouthType.addAll(Arrays.asList(faceTypes));
    }
    public boolean hasType(BodyType type) {
        return mouthType.contains(type);
    }
    public void stretchLips(){
        if (this.hasType(BodyType.MONSTROUS)){
            System.out.println(this.getOwner()+ " изобразила на лице чудовищно широкую улыбку");

        } else{
            System.out.println(this+" улыбнулась");
        }
    }
}
