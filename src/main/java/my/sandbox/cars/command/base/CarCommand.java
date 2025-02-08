package my.sandbox.cars.command.base;

import java.util.List;

import my.sandbox.cars.storage.Car;

public interface CarCommand<R> {
    R execute(List<Car> cars);
}
