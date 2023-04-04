package my.sandbox.mvc;

import static my.sandbox.mvc.Operation.DIVIDE;
import static my.sandbox.mvc.Operation.MINUS;
import static my.sandbox.mvc.Operation.MULTIPLE;
import static my.sandbox.mvc.Operation.PLUS;

public class Controller {

    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void newCommand(String... args) {
        Operation operation = null;

        switch (args[0]) {
            case "+" -> operation = PLUS;
            case "-" -> operation = MINUS;
            case "*" -> operation = MULTIPLE;
            case "/" -> operation = DIVIDE;
        }
        model.process(operation, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }

}
