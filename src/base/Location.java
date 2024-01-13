package base;

import java.util.ArrayList;
import java.util.Arrays;
import enums.ItemType;
import enums.LocType;
import exception.ObjectAddedToLocationException;

public class Location {
    protected String name;
    private ArrayList<Human> people = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<LocType> locType = new ArrayList<>();
    public Location(String name, LocType... locType){
        this.name = name;
        setTypes(locType);
    }
    public void setTypes(LocType... locTypes) {
        this.locType.addAll(Arrays.asList(locTypes));
    }
    public LocType[] getTypes() {
        LocType[] locType1 = new LocType[this.locType.size()];
        return this.locType.toArray(locType1);
    }
    public boolean hasType(LocType locType) {
        return this.locType.contains(locType);
    }
    public void setPeople(Human... people) throws ObjectAddedToLocationException {
        for (Human human:people) {
            if (this.people.contains(human)) {
                throw new ObjectAddedToLocationException(human + " уже находится в этой локации");
            }
            this.people.add(human);
            human.setLocation(this);
        }
    }
    public Human[] getPeople() {
        Human[] people = new Human[this.people.size()];
        return this.people.toArray(people);
    }
    public void removePeople(Human... people) {
        for (Human human : people) {
            this.people.remove(human);
        }
    }
    protected void addHuman(Human human){
        this.people.add(human);
    }
    protected void addItem(Item item){
        this.items.add(item);
    }
    public void setItems(Item... items) {
        this.items.addAll(Arrays.asList(items));
        for (Item item : items) {
            item.setLocation(this);
        }
    }
    public Item[] getItems() {
        Item[] items = new Item[this.items.size()];
        return this.items.toArray(items);
    }
    public void removeItems(Item... items) {
        for(Item item : items){
            this.items.remove(item);
        }
    }
    @Override
    public String toString() {
        return name;
    }
}
