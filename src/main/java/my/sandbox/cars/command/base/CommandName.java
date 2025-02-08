package my.sandbox.cars.command.base;

import java.util.Arrays;

public enum CommandName {
    COUNT_TYPES("count types"),
    COUNT_ALL("count all"),
    AVERAGE_PRICE("average price"),
    EXIT("exit"),
    ADD("add");

    private final String name;

    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("checkstyle:streamOf")
    public static CommandName lookup(String commandName) {
        return Arrays.stream(values())
            .filter(command -> commandName.startsWith(command.getName()))
            .findFirst()
            .orElse(null);
    }
}
