package enums;

public enum Clothes {
    GLOVES("перчатки"),
    DRESS("платье");
    final String name;
    Color color;
    Clothes(String name){
        this.name = name;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void getColor() {
        System.out.println(color);
    }

    public String toString(){
        return name;
    }
}
