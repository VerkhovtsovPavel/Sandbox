package my.sandbox.cars.storage;

import java.util.ArrayList;
import java.util.List;

import my.sandbox.cars.command.CarCommand;


public final class Storage {

	private final List<Car> storage;

	private static Storage instance;

	private Storage() {
		this.storage = new ArrayList<>();
	}

	public <R> R execute(CarCommand<R> command) {
		return command.execute(this.storage);
	}

	public static Storage getInstance() {
		if (instance == null) {
			instance = new Storage();
		}
		return instance;
	}


}
