package enums;

public enum Occupation {
    GRAVEDIGGER(" могилщик"),
    UNDERTAKER("помощник директора"),
    MECHANIC("механик"),
    DIR_FUNERAL_HOME("директор похоронного бюро, роспоряжавщийся церемонией ");
    final String name;
    Occupation(String name){
        this.name=name;
    }
    @Override
    public String toString() {
        return name;
    }
}
