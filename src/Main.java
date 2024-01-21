import base.Human;
import base.Item;
import base.Position;
import element.Wind;
import enums.*;
import base.Location;
import exception.ObjectAddedToLocationException;
import exception.WrongDriverException;
import item.*;

public class Main {
    public static void main(String[] args) throws ObjectAddedToLocationException{
        try {
            Location cemetery = new Location("кладбище", LocType.QUIETLY, LocType.BURIAL);
            Human director = new Human("директор",56, Occupation.DIR_FUNERAL_HOME);
            Human rachel = new Human("Рэчел",35);
            Book book = new Book("Евангелие от Матфея", 280);
            Human luis = new Human("Луис",36);
            Human oz = new Human("Оз",40, Occupation.GRAVEDIGGER);
            Corpse gadge = new Corpse("мертвец","Гэдж");
            Grave grave = new Grave("могила",gadge);
            grave.setEdgeColor(Color.BRIGHT_GREEN);
            Coffin coffin = new Coffin("гроб",gadge, Color.WHITE, grave);
            Human irvin = new Human("Ирвин",62);
            irvin.setTypes(HumanType.EMBARRASSED, HumanType.CONFUSED);
            irvin.getHead().getFace().setTypes(FaceType.EYES_BAG, FaceType.BRISTLE);
            cemetery.setPeople(irvin, luis, rachel, oz, director);
            irvin.getHair().setTypes(HairType.GRAY, HairType.THIN);
            Basket[] basket = new Basket[5];
            for (int i = 0; i < basket.length; i++) {
                basket[i] = new Basket("корзина");
                basket[i].setFlowers();basket[i].setLocation(cemetery);
            }
            Memorial memorial = new Memorial("памятник","Фиппс", ItemType.PSEUDO_ROMAN, ItemType.HUGE);
            Car car = new Car("грузовик", oz);
            car.setType(ItemType.INCONSPICUOUS);
            Car cars = new Car("машины");
            Human[] visitors = new Human[10];
            for (int i = 0; i < visitors.length; i++) {
                visitors[i] = new Human(" присутствующий",  38);
                visitors[i].setLocation(cemetery);
                visitors[i].setThings(new Umbrella("зонт",Color.BLACK, ItemType.GOVERNMENT));
            }
            cemetery.setItems(book, grave, coffin, car, memorial);

            rachel.askedRead(director, book, "'Пустите детей и не препятствуйте им приходить ко мне'");
            luis.stand(grave.getEdge());
            luis.look(irvin);
            irvin.look(luis);
            luis.argue(irvin);
            new Wind().blow(irvin.getHair());
            luis.seem();
            luis.tryToPity();
            coffin.stand(grave.getEdge());
            luis.look(grave.getEdge());
            for (Basket bask : basket) {
                bask.stand(grave.getEdge());
            }
            oz.startCar(car);
            luis.look(cemetery);
            director.say(" 'Склоним головы в знак скорби'");
            for (Human human : cemetery.getPeople()) {
                human.getHead().bow();
            }
            luis.look(car);
            if (luis.hasType(HumanType.CONFUSED)) {
                luis.understand();
            }
            car.stand(memorial);
            oz.smoke();
            oz.putIn(car, coffin);
            try {
                oz.drive(car);
            } catch (WrongDriverException e) {
                System.err.println(e.getMessage());
            }
            director.say(" Аминь");
            luis.takeBodyPart(rachel.getLefthands());
            rachel.tryToProtest();
            luis.stand(cars);
            for (Human h : cemetery.getPeople()) {
                director.setThings(h.getThings());
            }


            Human assistant = new Human("помощник",27, Occupation.UNDERTAKER);
            Human ellie = new Human("Элли",13);
            ellie.setTypes(HumanType.ANXIOUS);
            luis.setTypes(HumanType.SILENT);
            Human jude = new Human("Джуд",51, Occupation.MECHANIC);
            jude.getHead().getFace().setTypes(FaceType.EXHAUSTED);
            Rack rack = new Rack("стойка");
            rack.setType(ItemType.SURREAL);
            Car hundai = new Car("машина", luis);
            Picture photo = new Picture("фото", gadge);
            ellie.setThings(photo);
            cemetery.setPeople(ellie, jude); cemetery.setItems(rack, hundai,photo);
            System.out.println();

            assistant.setThings(director.getThings());
            assistant.putIn(rack, assistant.getThings());
            luis.takeBodyPart(ellie.getRighthands());
            luis.stand(hundai);
            ellie.setClothes(Clothes.DRESS, Clothes.GLOVES);
            jude.goUpTo(luis);
            luis.getInCar(hundai, rachel, ellie);
            luis.look(jude);
            jude.say(luis, "— Как ты, Луис?");
            jude.say(rachel, "— Как вы, Рэчел?");
            jude.say(ellie, "— А ты, дорогая?");
            jude.sayAbout(ellie, photo);
            Position past = new Position() {
                @Override
                public void addPosition(Human human) {
                    System.out.print("P.S: ");
                    Human clone = human;
                    clone.setLocation(new Location("в прошлом"));
                    action(clone);
                }
                @Override
                public void addPosition(Item item) {
                }
                public void action(Human clone) {
                    final int age = 30;
                    class Disassembler {
                        public void work(Human human, Car car) {
                            human.setAge(age);
                            car.setLocation(clone.getLocation());
                            human.dissamble(car);
                        }
                    }
                    new Disassembler().work(clone, new Car("дорожные"));
                }
            };
            past.addPosition(jude);
        } catch(ObjectAddedToLocationException e){
            System.err.println(e.getMessage());
        }

    }

}