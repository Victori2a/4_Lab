package enums;

public enum BodyType {
    EYES_BAG("мешки под глазами"),
    BRISTLE("щетина на щеках"),
    EXHAUSTED("измученное"),
    THIN("редкие"),
    MONSTROUS("чудовищная"),
    WIDE("широкая"),
    CALLOUSED("мозолистых"),
    GRAY("седые");
    String name;
    BodyType(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}