package interfaces;

import base.Human;
import base.Item;
import exception.WrongDriverException;
import item.Car;

public interface Drive {
    public void drive(Car car) throws WrongDriverException;
    public void startCar(Car car);
    public default void dissamble(Car car){
        car.getMechanisms();
        System.out.print(this + " разбирал "+car.name+" машины и копался в механизмах ");
    }
    public void getInCar(Car car, Human... humans);
}
