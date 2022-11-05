package simulation.place.type;

import simulation.place.Place;
import simulation.util.Counter;

public class Home extends Place {

    public Home(Counter counter) {
        super(counter);
    }

    @Override
    public double getInfectionRate() {
        return 1.5;
    }
}