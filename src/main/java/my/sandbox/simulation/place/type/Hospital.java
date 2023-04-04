package my.sandbox.simulation.place.type;

import my.sandbox.simulation.place.Place;
import my.sandbox.simulation.util.Counter;

public class Hospital extends Place {

    public Hospital(Counter counter) {
        super(counter);
    }

    @Override
    @SuppressWarnings("checkstyle:MagicNumber")
    public double getInfectionRate() {
        return 0.5;
    }
}
