package my.sandbox.simulation.person;

public enum HealthState {
    HEALTHY(false, false),
    INFECTED(true, false),
    CONTAGIOUS(true, true),
    SICK(true, true),
    DEAD(false, false),
    RESISTED(false, false);

    private final boolean sick;
    private final boolean contagious;

    HealthState(final boolean sick, final boolean contagious) {
        this.sick = sick;
        this.contagious = contagious;
    }

    public boolean isSick() {
        return sick;
    }

    public boolean isContagious() {
        return contagious;
    }
}
