package enums;

public enum LocType {
    QUIETLY("тихо"),
    BURIAL(" всё покрыто могилами");
    String name;
    LocType(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
