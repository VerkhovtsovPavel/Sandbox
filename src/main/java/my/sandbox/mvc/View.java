package my.sandbox.mvc;


import java.util.Scanner;
import java.util.concurrent.Flow;


public class View implements Flow.Subscriber<String> {

    private final Scanner source;
    private final Controller controller;

    public View(Scanner source, Controller controller, Flow.Publisher<String> observable) {
        this.source = source;
        this.controller = controller;
        observable.subscribe(this);
    }

    public void start() {
        while (true) {
            String line = source.nextLine();
            String[] words = line.split("\\s+");
            controller.newCommand(words);
        }
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(String s) {
        System.out.println(s);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("An error happens");
    }

    @Override
    public void onComplete() {

    }
}
