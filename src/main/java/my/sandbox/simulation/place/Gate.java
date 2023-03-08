package my.sandbox.simulation.place;

import my.sandbox.simulation.util.Counter;

public class Gate extends Place {

    public Gate() {
        super(new Counter());
    }

    @Override
    public double getInfectionRate() {
        return 0;
    }
}
