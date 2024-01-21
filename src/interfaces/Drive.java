package interfaces;

import base.Human;
import exception.WrongDriverException;
import item.Car;

public interface Drive {
    void drive(Car car) throws WrongDriverException;
    default void startCar(Car car){
        System.out.println(car.getDriver() + " завёл машину");
        car.started();
    }
    default void dissamble(Car car){
        if (car.isSuitable()){
            car.getMechanisms();
            System.out.print(this + " разбирал "+car.getName()+" машины и копался в их механизмах ");
        }else{
            System.out.println(this+ " продолжил разбирать механизмы");
        }
    }
    void getInCar(Car car, Human... humans);
}
