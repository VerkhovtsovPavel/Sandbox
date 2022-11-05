package simulation.place.type;

import simulation.place.Place;
import simulation.util.Counter;

public class Park extends Place {

    public Park(Counter counter) {
        super(counter);
    }

    @Override
    public double getInfectionRate() {
        return 0.1;
    }
}