package my.sandbox.simulation.place.type;

import my.sandbox.simulation.place.Place;
import my.sandbox.simulation.util.Counter;

public class Work extends Place {

    public Work(final Counter counter) {
        super(counter);
    }

    @Override
    public double getInfectionRate() {
        return 1;
    }
}
