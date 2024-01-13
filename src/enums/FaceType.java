package enums;

public enum FaceType {
    EYES_BAG("мешки под глазами"),
    BRISTLE("щетина на щеках"),
    EXHAUSTED("измученное");
    String name;
    FaceType(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
