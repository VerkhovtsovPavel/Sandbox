package my.sandbox.cars.command;

import java.util.List;
import java.util.stream.Collectors;

import my.sandbox.cars.storage.Car;

public class CountTypeCommand implements CarCommand<Integer> {
    @Override
    public Integer execute(List<Car> list) {
        return list.stream()
            .map(Car::brand)
            .collect(Collectors.toSet())
            .size();
    }
}
