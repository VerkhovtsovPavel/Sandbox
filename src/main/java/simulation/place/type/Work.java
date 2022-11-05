package simulation.place.type;

import simulation.place.Place;
import simulation.util.Counter;

public class Work extends Place {

    public Work(Counter counter) {
        super(counter);
    }

    @Override
    public double getInfectionRate() {
        return 1;
    }
}