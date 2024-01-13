package enums;

public enum HairType {
    THIN("редкие"),
    GRAY("седые");
    String name;
    HairType(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
