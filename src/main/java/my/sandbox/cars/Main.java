package my.sandbox.cars;

import static java.lang.String.format;
import static my.sandbox.cars.util.AvailableCommand.*;
import static my.sandbox.common.logger.CommonLogger.LOG;

import java.util.Scanner;

import my.sandbox.cars.command.AddCarCommand;
import my.sandbox.cars.command.AveragePriceByBrandCommand;
import my.sandbox.cars.command.AveragePriceCommand;
import my.sandbox.cars.command.CountAllCommand;
import my.sandbox.cars.command.CountTypeCommand;
import my.sandbox.cars.storage.Car;
import my.sandbox.cars.storage.Storage;

public class Main {

	private static final String VERSION = "Pro 72";

	public static void main(String[] args) {
		LOG.info(format("Welcome to car's dealership terminal (%s)%n", VERSION));

		boolean isExit = false;

		while(!isExit) {
			LOG.info("> ");
			String newCommand = readLine().toLowerCase().trim();
			// Process parameter-less commands
			String result = switch (newCommand) {
				case COUNT_TYPES -> Storage.getInstance().execute(new CountTypeCommand()).toString();
				case COUNT_ALL -> Storage.getInstance().execute(new CountAllCommand()).toString();
				case AVERAGE_PRICE -> Storage.getInstance().execute(new AveragePriceCommand()).toString();
				case EXIT -> {
					isExit = true;
					yield "Exit initiated";
				}
				default -> null;
			};

			// Process parametrized commands
			if (result == null) {
				if(newCommand.startsWith(AVERAGE_PRICE)) {
					String brand = newCommand.replace(AVERAGE_PRICE, "").trim();
					result = Storage.getInstance().execute(new AveragePriceByBrandCommand(brand)).toString();
				} else if(newCommand.startsWith(ADD)) {
					String carDetails = newCommand.replace(ADD, "").trim();
					String[] s = carDetails.split(" ");
					try {
						Car newCar = new Car(s[0], s[1], parseInt(s[2]), parseInt(s[3]));
						result = Storage.getInstance().execute(new AddCarCommand(newCar)).toString();
					} catch (Exception e) {
						result = "Fail to add new car. Please check input parameters";
					}
				}
			}

			// Process invalid command
			if (result == null) {
				result = "Unsupported command";
			}

			LOG.info(format(">> %s%n", result));
		}
		LOG.info(format("Thank you for use car's dealership terminal (%s)%n", VERSION));
	}

	private static String readLine() {
		//TODO Avoid object recreation
		return new Scanner(System.in).nextLine();
	}

	private static int parseInt(final String arg)  {
			return Integer.parseInt(arg);
	}
}


