package my.sandbox.cars.command;

import java.util.List;

import my.sandbox.cars.storage.Car;

public record AddCarCommand(Car newCar) implements CarCommand<Boolean> {
    @Override
    public Boolean execute(List<Car> list) {
        return list.add(newCar);
    }
}
