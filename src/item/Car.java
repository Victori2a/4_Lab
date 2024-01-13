package item;

import base.Human;
import base.Item;
import base.Position;
import enums.Color;
import enums.ItemType;
import interfaces.AbleToStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Car extends Item implements Position, AbleToStore {
    private boolean isSuitable = true;
    private Human driver = null;
    private boolean headlights = false;
    private int speed = 0;
    private ArrayList<Item> trunk = new ArrayList<>();
    private ArrayList<Human> interior = new ArrayList<>();
    public Car(String name, Human driver){
        super(name);
        this.driver = driver;
    }
    public Car(String name){super(name);}
    public void setItems(Item... items) {
        this.trunk.addAll(Arrays.asList(items));
    }
    @Override
    public String getWhere() {
        return "машину";
    }

    public void setHumans(Human... humans) {
        this.interior.addAll(Arrays.asList(humans));
        System.out.println("В машину "+getDriver()+"а сели ");
        for (Human h:humans){
            System.out.print(h+", ");
        }
    }
    public boolean getHeadlights(){
        return headlights;
    }
    public Item[] getItems() {
        Item[] trunk1 = new Item[this.trunk.size()];
        return this.trunk.toArray(trunk1);
    }
    public void started(){
        this.headlights = true;
        System.out.println(name+" завёлся. Фары загорелись");
        this.setType(ItemType.BRIGHT);
    }
    public void stand(Position position){
        position.addPosition(this);
        if (this.hasType(ItemType.INCONSPICUOUS)) {
            System.out.println(this + " стоит за " + position + ", где его никто не видит");
        }
    }
    public Human getDriver(){
        return driver;
    }
    public void start(){
        this.speed = (int) (Math.random() * 120);
        System.out.println(name+ " пришёл в движение. Скорость грузовика: " + speed);
    }
    public void getMechanisms(){
        isSuitable = false;
    }
    public String toString(){
        return "машиной";
    }

    @Override
    public void addPosition(Human human) {
        human.addPos(this);
    }
    public void addPosition(Item item) {
        item.addPos(this);
    }
}

