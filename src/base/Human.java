package base;

import enums.*;
import interfaces.*;
import item.*;
import humanPart.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import exception.*;

public class Human implements Drive{
    protected Occupation occupation;
    protected String name;
    protected Position position;
    protected Location location;
    protected ArrayList<HumanType> humanTypes = new ArrayList<>();
    protected ArrayList<Human> foe = new ArrayList<>();
    protected ArrayList<Item> things = new ArrayList<>();
    protected ArrayList<Clothes> clothes = new ArrayList<>();
    protected Human lookHuman;
    protected Item lookItem;
    protected Location lookLocation;
    public int age;
    protected double[] conditions = new double[Condition.values().length];
    {for (int i = 0; i<Condition.values().length;i++){
      this.conditions[i] = 60;
    }}
    public Head head = new Head("голова", this);
    public Hair hair = new Hair("волосы", this);
    public Hands righthands = new Hands("правая рука", this);
    public Hands lefthands = new Hands("левая рука", this);
    public Human(Occupation occupation){
        this.occupation = occupation;
    }
    public Human(String name,Occupation occupation){
        this.name = name;
        this.occupation = occupation;
    }
    public Human(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setLocation(Location location) {
        this.location = location;
        location.addHuman(this);
    }
    public Location getLocation() {
        return location;
    }
    public void setTypes(HumanType... humanTypes) {
        this.humanTypes.addAll(Arrays.asList(humanTypes));
    }
    public void setThings(Item... thing){
        this.things.addAll(Arrays.asList(thing));
    }
    public Item[] getThings() {
        Item[] things1 = new Item[this.things.size()];
        return this.things.toArray(things1);
    }
    public boolean hasType(HumanType humanType) {
        return humanTypes.contains(humanType);
    }
    public void removeType(HumanType... humanType) {
        for (HumanType type : humanType) {
            this.humanTypes.remove(type);
        }
    }
    public void read(Book book, String start){
        this.lookItem = book;
        this.setThings(book);
        System.out.println(this.occupation + " читал " + book.getName()+" cо слов :"+ start);
    }
    public void stand(Position position){
        position.addPosition(this);
        System.out.println(this + " встал рядом с " + position);
        if (this.righthands.hold!=null){
            System.out.println("и "+ righthands.hold + " вместе с ним");
            position.addPosition(righthands.hold);
        }
        if (this.lefthands.hold!=null){
            System.out.println("и "+ lefthands.hold + " вместе с ним");
            position.addPosition(lefthands.hold);
        }
    }
    public void give(Human human, Item item){
        this.getThings();
        human.setThings(item);
        System.out.print(human+" получил "+item.getName()+" от "+ this);
        if (this.hasType(HumanType.ANXIOUS)){
            System.out.println(" после мучительных колебаний ");
        }
        if (human.occupation==Occupation.MECHANIC){
            System.out.println(human+" держал "+item.getName()+" в cвоих мозолистых руках" );
        }
    }
    public void look(Human human) {
        lookHuman = human;
        lookItem = null;
        lookLocation = null;
        System.out.println(this + " посмотрел на " + human);
        if (this.hasType(HumanType.EMBARRASSED)){
            System.out.println(" и быстро отвёл глаза");
            lookHuman = null;
        } if (human.head.getFace().hasType(FaceType.EXHAUSTED)){
            human.setCondition(Condition.FUN,-11);
            System.out.println("Лицо "+human+"а было "+ FaceType.EXHAUSTED);
        }
    }
    public void look(Item item) {
        lookHuman = null;
        lookItem = item;
        lookLocation = null;
        System.out.println(this + " посмотрел на " + item.getName() );
        if (item.getColor() == Color.BRIGHT_GREEN){
            this.head.getEyes().act(this);
            this.setCondition(Condition.COMFORT, -5);
        }
        if (item.getClass()==Car.class){
            if (((Car) item).getHeadlights()){
                this.setTypes(HumanType.BLINDED, HumanType.CONFUSED);
                this.head.getEyes().act(this);
                this.setCondition(Condition.COMFORT, -8);
                this.head.getEyes().setClarity(-0.02);
            }
        }
    }
    public void look(Location location) {
        lookHuman = null;
        lookItem = null;
        lookLocation = location;
        System.out.print(this + " оглядывал " + location +". Здесь было  " );
        System.out.println(Arrays.toString(location.getTypes()));
        if (location.name == "кладбище"){
            setCondition(Condition.FUN, -5);
        }
    }
    public void askedRead(Human human, Book book, String start){
        System.out.println("по просьбе "+ this);
        human.read(book, start);
    }

    public void addPos(Position position){
        this.position = position;
    }
    public void argue(Human human){
        if (this.getLocation().hasType(LocType.QUIETLY)){
            System.out.println(this + " не поссорился с " + human + ", т.к на " + getLocation() + " должно быть тихо");
        } else {
            System.out.println(this+" поссорился с  " + human);
            this.foe.add(human);
            human.foe.add(this);
            setCondition(Condition.SATISFACTION,-7);
            human.setCondition(Condition.SATISFACTION,-7);
        }
    }
    public void say(String speech){
        System.out.println(this + " сказал " + speech);
        if (this.occupation==Occupation.DIR_FUNERAL_HOME){
            for (Human human : getLocation().getPeople()){
                human.setCondition(Condition.FUN,Math.random()*3);
                human.setCondition(Condition.SUPRISE, 1);
            }
        }
    }
    public void say(Human human, String speech){
        human.setCondition(Condition.SUPRISE, 1);
        if (this.lookHuman!=human){
            look(human);
        }
        System.out.println(speech);
        if (human.hasType(HumanType.SILENT)){
            human.nod();
            System.out.println(human+" только кивнул");
            human.setCondition(Condition.COMFORT, -4);
        }
        else {
            if (human.hasType(HumanType.ANXIOUS)){
                System.out.println("Нормально, отозвалась " + human);
                human.smile();
                human.setCondition(Condition.SATISFACTION, -3);
            }
            else{
                System.out.println("Всё нормально, прошептала "+ human);
            }
        }
    }
    public void say(Human human, Item item){
        human.setCondition(Condition.SUPRISE, 1);
        this.lookItem = item;
        System.out.println("Что это у тебя за "+ item.getName()+"? Спросил у "+human+" "+this);
    }
    public void smile(){
        head.getMouth().stretchLips();
    }
    public void seem(){
        if (this.lookHuman.head.getFace().hasType(FaceType.BRISTLE)){
            System.out.println(this +" казалось, что " + this.lookHuman + " выглядит ещё старше");
        }
        if (this.lookHuman.hasType(HumanType.CONFUSED)){
            System.out.println(this+ " казалось, что "+ this.lookHuman + " просто не соображал, что происходит");
            lookHuman.setCondition(Condition.COLLECT, -6);
        }
    }
    public void tryToPity(){
        if (Math.random() < 0.8d){
            System.out.println(this+" пытался сжалиться над " + this.lookHuman + "ом, но у него не получилось");
            setTypes(HumanType.INSENSITIVE);
            setCondition(Condition.DILIGENCE, -3);
        } else{
            System.out.println(this+ "у стало жалко "+ this.lookHuman);
            setTypes(HumanType.COMPASSIONATE);
            setCondition(Condition.DILIGENCE, 4);
        }
    }
    public void tryToProtest(){
        if (Math.random() < 0.7d){
            System.out.println(this+" пыталась протестовать, но " +this.lookHuman + " был твёрд");
            lookHuman.setTypes(HumanType.PERSISTENT);
            setCondition(Condition.DILIGENCE, -6);
            setTypes(HumanType.SAD);
        } else{
            System.out.println(this+ " пыталась протестовать и смогла убедить "+ this.lookHuman);
            lookHuman.setTypes(HumanType.COMPLIANT);
            setCondition(Condition.DILIGENCE, 10);
        }
    }
    public void understand(){
        if (Math.random() < 0.8d){
            System.out.println(this + " понял, что это такое");
            if (this.getName() == "Луис"){
                this.removeType(HumanType.BLINDED, HumanType.CONFUSED);
            }
        } else{
            System.out.println(this + " не понял, что  это такое");
        }
    }
    public void smoke(){
        Cigarette cigarette = new Cigarette("сигарета");
        cigarette.lit();
        System.out.println(this + " решил покурить");
        setCondition(Condition.HEALTH, -0.3);
        cigarette.goOut();
        setTypes(HumanType.SMOKING);
    }
    public void putIn(AbleToStore store, Item... items){
        if (items.length==1){
            Item item = items[0];
            if(item.getClass()== Coffin.class){
                System.out.println(this + " положил гроб в "+ store.getWhere());
            }
        }
        store.setItems(items);
    }
    public void drive(Car car) throws WrongDriverException{
        if (this!=car.getDriver()){
            throw new WrongDriverException(this+" не может сесть за руль, т.к не вписан в страховку!");
        }
        System.out.println(this + " нажал на газ");
        car.start();
        getLocation().removePeople(this);

    }
    public void getInCar(Car car, Human... humans){
        car.setHumans(humans);
        ArrayList<Human> people = new ArrayList<>(Arrays.asList(humans));
        people.forEach(human -> addPos(car));
    }
    public void dissamble(Car car){
        Drive.super.dissamble(car);
        System.out.println(this.getLocation());
    }
    public void goUpTo(Human human){
        this.stand(human.position);
        this.setLocation(human.getLocation());
    }
    public void takeBodyPart(BodyPart part){
        if (righthands.hold == null){
            this.righthands.take(part);
            part.getOwner().lookHuman = this;
        }
        else{
            this.lefthands.take(part);
        }
    }
    public void bowHead(){
        head.bow();
        lookHuman = null;
        lookItem = null;
        lookLocation = null;
    }
    public void nod(){
        head.bow();
        head.raise();
    }

    public void setCondition(Condition condition, double var){
        switch (condition){
            case COMFORT:
                this.conditions[Condition.COMFORT.ordinal()] +=var;
                break;
            case SATISFACTION:
                this.conditions[Condition.SATISFACTION.ordinal()] +=var;
                break;
            case HEALTH:
                this.conditions[Condition.HEALTH.ordinal()] +=var;
                break;
            case DILIGENCE:
                this.conditions[Condition.DILIGENCE.ordinal()] +=var;
                break;
            case FUN:
                this.conditions[Condition.FUN.ordinal()] +=var;
                break;
            case COLLECT:
                this.conditions[Condition.COLLECT.ordinal()] +=var;
                break;
            case SUPRISE:
                this.conditions[Condition.SUPRISE.ordinal()] +=var;
                break;
        }
    }
    public void setAge(int age){
        this.age = age;
    }
    public double getCondition(Condition cond){
        return this.conditions[cond.ordinal()];
    }
    public void setClothes(Clothes... clothes){
        for (Clothes clothes1: clothes){
            clothes1.setColor(Color.values()[(int)(Math.random()*Color.values().length)]);
        }
        this.clothes.addAll(Arrays.asList(clothes));
        System.out.println(this + " была одета в ");
        for (Clothes c : clothes){
            System.out.print(c+" цвета: ");
            c.getColor();
        }
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return name.equals(human.name);
    }
    public int hashCode(){
        int hash = 31;
        hash += 31 * Objects.hashCode(name);
        return hash;
    }

}
