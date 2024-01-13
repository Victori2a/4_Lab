package humanPart;

import base.Human;
import enums.HumanType;

import java.util.ArrayList;
import java.util.Arrays;

public class Mouth extends BodyPart{
    public Mouth(String name, Human owner) {
        super(name, owner);
    }
    public void stretchLips(){
        if (this.getOwner().hasType(HumanType.ANXIOUS)){
            System.out.println(this.getOwner()+ " изобразила на лице чудовищно широкую улыбку");

        } else{
            System.out.println(this + " улыбнулась");
        }
    }
}
