package my.sandbox.mvc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(in, controller, model);
        view.start();
    }
}
