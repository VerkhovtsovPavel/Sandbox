package my.sandbox.classification.main;

public class Main {

    public static void main(final String[] args) {
        Classification classification = new MaxMin(600);
        classification.process();
    }
}
