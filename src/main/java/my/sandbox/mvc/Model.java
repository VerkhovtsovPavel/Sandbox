package my.sandbox.mvc;

import java.util.concurrent.Flow;

public class Model implements Flow.Publisher<String> {

    private Flow.Subscriber<? super String> subscriber;

    public void process(Operation operation, int... args) {
        switch (operation) {
            case PLUS -> {
                subscriber.onNext("" + (args[0] + args[1]));
            }
            case MINUS -> {
                subscriber.onNext("" + (args[0] - args[1]));
            }
            case MULTIPLE -> {
                subscriber.onNext("" + (args[0] * args[1]));
            }
            case DIVIDE -> {
                subscriber.onNext("" + (args[0] / args[1]));
            }
        }
    }

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
    }
}
