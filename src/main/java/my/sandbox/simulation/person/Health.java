package my.sandbox.simulation.person;


import my.sandbox.simulation.util.Constant;
import my.sandbox.simulation.util.Randomizer;

public class Health {

    private HealthState currentState = HealthState.HEALTHY;
    private int periodOfIllness = 0;

    public void tick() {

        if (currentState.isSick()) {
            periodOfIllness++;

            if (currentState == HealthState.SICK) {
                // TODO Think about gauss distribution depends on probability
                if (Randomizer.nextDouble() < Constant.DEAD_PROBABILITY) {
                    currentState = HealthState.DEAD;
                }
            }
        }

        if (periodOfIllness == Constant.PRE_CONTAGIOUS_PERIOD) {
            currentState = HealthState.CONTAGIOUS;
        }

        if (periodOfIllness == Constant.HIDDEN_PERIOD) {
            currentState = HealthState.SICK;
        }

        if (periodOfIllness == Constant.ILLNESS_PERIOD) {
            currentState = HealthState.RESISTED;
        }
    }

    public boolean infected() {
        if (currentState == HealthState.HEALTHY) {
            currentState = HealthState.INFECTED;
            return true;
        }
        return false;
    }

    public HealthState getCurrentState() {
        return currentState;
    }

}

