package my.sandbox.simulation.person;

import my.sandbox.common.util.Randomizer;
import my.sandbox.simulation.util.Constant;

public class Health {

    private HealthState currentState = HealthState.HEALTHY;
    private int periodOfIllness;

    public void tick() {

        if (currentState.isSick()) {
            periodOfIllness++;

            // TODO Think about gauss distribution depends on probability
            if (currentState == HealthState.SICK && Randomizer.nextDouble() < Constant.DEAD_PROBABILITY) {
                currentState = HealthState.DEAD;
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

