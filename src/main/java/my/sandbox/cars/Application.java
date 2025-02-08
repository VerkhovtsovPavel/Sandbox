package my.sandbox.cars;

import static my.sandbox.cars.command.base.CommandName.ADD;
import static my.sandbox.cars.command.base.CommandName.AVERAGE_PRICE;
import static my.sandbox.common.constant.IntConstant.ONE;
import static my.sandbox.common.constant.IntConstant.THREE;
import static my.sandbox.common.constant.IntConstant.TWO;
import static my.sandbox.common.constant.IntConstant.ZERO;
import static my.sandbox.common.constant.StringConstant.EMPTY;
import static my.sandbox.common.constant.StringConstant.SPACE;
import static my.sandbox.common.logger.CommonLogger.LOG;
import static my.sandbox.common.util.ConsoleScanner.CONSOLE_SCANNER;
import static my.sandbox.common.util.IntegerUtil.parseInt;

import my.sandbox.cars.command.AddCarCommand;
import my.sandbox.cars.command.AveragePriceByBrandCommand;
import my.sandbox.cars.command.AveragePriceCommand;
import my.sandbox.cars.command.CountAllCommand;
import my.sandbox.cars.command.CountTypeCommand;
import my.sandbox.cars.command.base.CommandName;
import my.sandbox.cars.storage.Car;
import my.sandbox.cars.storage.Storage;

public final class Application {
    private static final String VERSION = "Pro 72";
    private static final String EXIT_INITIATED = "Exit initiated";

    private Application() {
    }

    public static void main(String[] args) {
        LOG.info("Welcome to car's dealership terminal {}", VERSION);

        while (true) {
            LOG.info("> ");
            String newCommand = CONSOLE_SCANNER.nextLine().toLowerCase().trim();
            CommandName command = CommandName.lookup(newCommand);

            if (command == null) {
                LOG.info(">> Unsupported command [{}]", newCommand);
            }
            else {
                // Process parameter-less commands
                String result = handleParameterlessCommands(command);
                // Process parametrized commands
                result = handleParametrizeCommands(result, newCommand);
                // Process invalid command
                result = handleUnsupportedCommands(result);
                LOG.info(">> {}", result);

                if (EXIT_INITIATED.equals(result)) {
                    break;
                }
            }
        }
        LOG.info("Thank you for use car's dealership terminal ({})", VERSION);
    }

    private static String handleUnsupportedCommands(String result) {
        if (result == null) {
            return "Unsupported command";
        }
        return result;
    }

    @SuppressWarnings("PMD.AvoidCatchingGenericException")
    private static String handleParametrizeCommands(String result, String newCommand) {
        if (result == null) {
            if (newCommand.startsWith(AVERAGE_PRICE.getName())) {
                String brand = newCommand.replace(AVERAGE_PRICE.getName(), EMPTY).trim();
                return Storage.getInstance().execute(new AveragePriceByBrandCommand(brand)).toString();
            }
            else if (newCommand.startsWith(ADD.getName())) {
                String carDetails = newCommand.replace(ADD.getName(), EMPTY).trim();
                String[] s = carDetails.split(SPACE);
                try {
                    Car newCar = new Car(s[ZERO], s[ONE], parseInt(s[TWO]), parseInt(s[THREE]));
                    return Storage.getInstance().execute(new AddCarCommand(newCar)).toString();
                }
                catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    return "Fail to add new car. Please check input parameters";
                }
            }
        }
        return result;
    }

    private static String handleParameterlessCommands(CommandName command) {
        return switch (command) {
            case COUNT_TYPES -> Storage.getInstance().execute(new CountTypeCommand()).toString();
            case COUNT_ALL -> Storage.getInstance().execute(new CountAllCommand()).toString();
            case AVERAGE_PRICE -> Storage.getInstance().execute(new AveragePriceCommand()).toString();
            case EXIT -> EXIT_INITIATED;
            default -> null;
        };
    }
}


