package item;

import base.Human;
import base.Item;
import base.Position;
import enums.ItemType;
import interfaces.AbleToStore;
import java.util.ArrayList;
import java.util.Arrays;

public class Car extends Item implements Position, AbleToStore {
    private boolean isSuitable = true;
    private Human driver = null;
    private boolean headlights = false;
    private int speed;
    private final ArrayList<Item> trunk = new ArrayList<>();
    private final ArrayList<Human> interior = new ArrayList<>();
    public Car(String name, Human driver){
        super(name);
        this.driver = driver;
        this.speed = 0;
    }
    public Car(String name){super(name);}
    @Override
    public void setItems(Item... items) {
        this.trunk.addAll(Arrays.asList(items));
    }
    @Override
    public String getWhere() {
        return "машину";
    }

    public void setHumans(Human... humans) {
        this.interior.addAll(Arrays.asList(humans));
        System.out.print("В машину "+getDriver()+"а сели ");
        for (Human h:humans){
            h.addPos(this);
            System.out.print(h+", ");
        }
    }
    public boolean getHeadlights(){
        return headlights;
    }
    public void started(){
        this.headlights = true;
        System.out.println(name+" завёлся. Фары загорелись");
        this.setType(ItemType.BRIGHT);
    }
    @Override
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
    public boolean isSuitable(){
        return isSuitable;
    }
    @Override
    public String toString(){
        if (getDriver()!=null){
            return name+" "+getDriver()+"а";
        } else{
            return name;
        }
    }

    @Override
    public void addPosition(Human human) {
        human.addPos(this);
    }
    @Override
    public void addPosition(Item item) {
        item.addPos(this);
    }
}

