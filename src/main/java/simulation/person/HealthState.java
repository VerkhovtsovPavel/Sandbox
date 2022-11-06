package simulation.person;

public enum HealthState {
    HEALTHY(false, false),
    INFECTED(true, false),
    CONTAGIOUS(true, true),
    SICK(true, true),
    DEAD(false, false),
    RESISTED(false, false);

    private final boolean isSick;
    private final boolean isContagious;

    HealthState(boolean isSick, boolean isContagious) {
        this.isSick = isSick;
        this.isContagious = isContagious;
    }

    public boolean isSick() {
        return isSick;
    }

    public boolean isContagious() {
        return isContagious;
    }
}
