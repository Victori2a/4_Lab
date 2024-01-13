package item;

import base.Item;

public class Basket extends Item {
    Flowers flowers;
    public Basket(String name) {
        super(name);
    }
    public void setFlowers(){
        this.flowers = Flowers.values()[(int)(Math.random()*Flowers.values().length)];
    }
    public String getFlowers(){
        return this.flowers.getName();
    }
    public static enum Flowers{
        ROSE("Розы"),
        TULIPS("Тюльпаны"),
        LILIES("Лилии");
        String name;
        Flowers(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
    public String toString(){
        return (name+", в которой " + this.getFlowers()+", ");
    }
}