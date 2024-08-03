package my.sandbox.cars.command;

import java.util.List;

import my.sandbox.cars.storage.Car;


public record AveragePriceByBrandCommand(String brand) implements CarCommand<Double> {

	@Override
	public Double execute(List<Car> list) {
		return list.stream()
				.filter(c -> c.brand().equals(brand))
				.mapToLong(Car::cost)
				.average()
				.orElse(0.0);
	}
}
