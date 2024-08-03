package my.sandbox.cars.storage;

import java.util.ArrayList;
import java.util.List;

import my.sandbox.cars.command.CarCommand;

public final class Storage {

	private final List<Car> cars;

	private static final Storage INSTANCE = new Storage();

	private Storage() {
		this.cars = new ArrayList<>();
	}

	public <R> R execute(CarCommand<R> command) {
		return command.execute(this.cars);
	}

	public static Storage getInstance() {
		return INSTANCE;
	}
}
