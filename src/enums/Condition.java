package enums;

public enum Condition {
    COMFORT("комфорт"),
    HEALTH("здоровье"),
    SATISFACTION("удовлетворённость"),
    DILIGENCE("старательность"),
    COLLECT("собранность"),
    SURPRISE("удивлённость"),
    FUN("радость");
    final String name;
    Condition(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name;
    }
}
