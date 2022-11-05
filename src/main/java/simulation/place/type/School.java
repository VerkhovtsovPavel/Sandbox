package simulation.place.type;

import simulation.place.Place;
import simulation.util.Counter;

public class School extends Place {

    public School(Counter counter) {
        super(counter);
    }

    @Override
    public double getInfectionRate() {
        return 1.2;
    }
}