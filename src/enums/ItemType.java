package enums;

public enum ItemType {
    PSEUDO_ROMAN("псевдоримский"),
    INCONSPICUOUS("незаметный"),
    BRIGHT("яркий"),
    HUGE("огромный"),
    SURREAL("сюрреалистический"),
    GOVERNMENT("казённый");
    final String name;
    ItemType(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

}

