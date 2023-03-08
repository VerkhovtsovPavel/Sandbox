package my.sandbox.simulation.place.type;

import my.sandbox.simulation.place.Place;
import my.sandbox.simulation.util.Counter;

public class Pub extends Place {

    public Pub(final Counter counter) {
        super(counter);
    }

    @Override
    public double getInfectionRate() {
        return 3;
    }
}
