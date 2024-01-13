package enums;

public enum ItemType {
    PSEUDO_ROMAN("псевдоримский"),
    INCONSPICUOUS("незаметный"),
    BRIGHT("яркий"),
    HUGE("огромный"),
    REPAIRED_LOCKS("с починенными замками"),
    SURREAL("сюрреалистический"),
    GOVERNMENT("казённый");
    String name;
    ItemType(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

}

