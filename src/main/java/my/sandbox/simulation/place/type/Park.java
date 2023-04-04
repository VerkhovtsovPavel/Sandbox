package my.sandbox.simulation.place.type;

import my.sandbox.simulation.place.Place;
import my.sandbox.simulation.util.Counter;

public class Park extends Place {

    public Park(Counter counter) {
        super(counter);
    }

    @Override
    @SuppressWarnings("checkstyle:MagicNumber")
    public double getInfectionRate() {
        return 0.1;
    }
}