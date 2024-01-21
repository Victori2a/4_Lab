package enums;

public enum HumanType {
    EMBARRASSED("смущённый"),
    CONFUSED("растерянный"),
    COMPASSIONATE("сострадательный"),
    INSENSITIVE("бесчувственный"),
    SMOKING("курящий"),
    PERSISTENT("настойчивый"),
    COMPLIANT("уступчивый"),
    SAD("грустный"),
    SILENT("молчаливый"),
    ANXIOUS("тревожный"),
    BLINDED("ослеплённый");
    final String name;
    HumanType(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}
