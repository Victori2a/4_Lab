package humanPart;

import base.Human;

public class Head extends BodyPart{
    private Eyes eyes;
    private Face face;
    private Mouth mouth;
    public Head(String name, Human owner) {
        super("голова", owner);
        eyes = new Eyes("глаза", owner);
        face = new Face("лицо", owner);
        mouth = new Mouth("рот", owner);
    }
    public void bow(){
    }
    public void raise(){
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
