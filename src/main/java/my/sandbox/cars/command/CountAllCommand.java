package my.sandbox.cars.command;

import java.util.List;

import my.sandbox.cars.storage.Car;

public class CountAllCommand implements CarCommand<Integer> {
	@Override
	public Integer execute(List<Car> list) {
		return list.size();
	}
}
