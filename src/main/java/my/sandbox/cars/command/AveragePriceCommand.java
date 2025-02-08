package my.sandbox.cars.command;

import java.util.List;

import my.sandbox.cars.storage.Car;

public class AveragePriceCommand implements CarCommand<Double> {
    @Override
    public Double execute(List<Car> list) {
        return list.stream()
            .mapToLong(Car::cost)
            .average()
            .orElse(0.0);
    }
}
