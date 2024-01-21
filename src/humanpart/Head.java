package humanpart;

import base.Human;

public class Head extends BodyPart{
    private final Eyes eyes;
    private final Face face;
    private final Mouth mouth;
    public Head(String name, Human owner) {
        super(name, owner);
        eyes = new Eyes("глаза", owner);
        face = new Face("лицо", owner);
        mouth = new Mouth("рот", owner);
    }
    public void bow(){
        getOwner().lookItem = null;
        getOwner().lookLocation=null;
        getOwner().lookHuman = null;
    }
    public void raise(Human human){
        if (getOwner().lookHuman!=null){
            getOwner().lookHuman=human;
        }
    }
    public Eyes getEyes(){
        return eyes;
    }
    public Face getFace(){
        return face;
    }
    public Mouth getMouth(){
        return mouth;
    }
}
