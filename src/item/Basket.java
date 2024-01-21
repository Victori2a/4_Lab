package item;

import base.Item;
import java.util.Random;

public class Basket extends Item {
    public static final int k = 5;
    private final Flowers[] flowers = new Flowers[k];
    public Basket(String name) {
        super(name);
    }
    public void setFlowers(){
        new Flowers().creatureBouquet();
    }

    public class Flowers{
        public String name;
        public final String[] names = new String[]{"Розы", "Лилии", "Тюльпаны", "Хризантемы","Ирисы"};
        public Flowers(){
            this.name = names[new Random().nextInt(names.length)];
        }
        public String getName(){
            return name;
        }
        public void creatureBouquet(){
            for (int i =0; i<k; i++){
                Basket.this.flowers[i] = new Flowers();
            }
        }
    }
    public String toString(){
        return name;
    }
}