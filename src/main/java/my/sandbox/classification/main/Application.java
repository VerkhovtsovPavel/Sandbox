package my.sandbox.classification.main;

import static my.sandbox.common.constant.IntConstant.HUNDRED;
import static my.sandbox.common.constant.IntConstant.SIX;

public final class Application {
    private Application() {
    }

    public static void main(final String[] args) {
        Classification classification = new KMeans(SIX * HUNDRED);
        classification.process();
    }
}
