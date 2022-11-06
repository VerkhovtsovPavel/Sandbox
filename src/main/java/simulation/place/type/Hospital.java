package simulation.place.type;

import simulation.place.Place;
import simulation.util.Counter;

public class Hospital extends Place {

    public Hospital(Counter counter) {
        super(counter);
    }

    @Override
    public double getInfectionRate() {
        return 0.5;
    }
}
