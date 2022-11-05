package simulation.place.type;

import simulation.place.Place;
import simulation.util.Counter;

public class Pub extends Place {

    public Pub(Counter counter) {
        super(counter);
    }

    @Override
    public double getInfectionRate() {
        return 3;
    }
}