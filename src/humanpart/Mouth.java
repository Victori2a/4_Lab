package humanpart;

import base.Human;
import enums.Condition;
import enums.HumanType;

public class Mouth extends BodyPart{
    public boolean open;
    public Mouth(String name, Human owner) {
        super(name, owner);
    }
    public void stretchLips(){
        if (this.getOwner().hasType(HumanType.ANXIOUS)){
            System.out.println(this.getOwner()+ " изобразила на лице чудовищно широкую улыбку");

        } else{
            getOwner().setCondition(Condition.FUN,3);
            System.out.println(this + " улыбнулась");
        }
    }
    public void move(){
        open = true;
    }
}
