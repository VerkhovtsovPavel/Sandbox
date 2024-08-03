package my.sandbox.classification.main;

public final class Application {

    public static void main(final String[] args) {
        Classification classification = new KMeans(600);
        classification.process();
    }

    private Application() {}
}
