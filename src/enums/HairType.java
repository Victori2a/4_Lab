package enums;

public enum HairType {
    THIN("редкие"),
    GRAY("седые");
    final String name;
    HairType(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
