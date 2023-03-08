package my.sandbox.mvc;

import static my.sandbox.mvc.Operation.*;

public class Controller {

    private Model model;

    public Controller(Model model){
        this.model = model;
    }

    public void newCommand(String... args) {
        Operation operation = null;

        switch (args[0]) {
            case "+" -> operation = PLUS;
            case "-" -> operation = MINUS;
            case "*" -> operation = MULTIPLE;
            case "/" -> operation = DIVIDE;
        };
        model.process(operation, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }

}
