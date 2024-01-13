package interfaces;

import base.Human;
import base.Item;
import exception.WrongDriverException;
import item.Car;

public interface Drive {
    void drive(Car car) throws WrongDriverException;
    default void startCar(Car car){
        System.out.println(car.getDriver() + " завёл машину");
        car.started();
    };
    default void dissamble(Car car){
        car.getMechanisms();
        System.out.print(this + " разбирал "+car.getName()+" машины и копался в их механизмах ");
    }
    void getInCar(Car car, Human... humans);
}
