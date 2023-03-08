package my.sandbox.welcome;

public enum Bonus {

    SURVEYOR("\uD83D\uDCCF"),
    REAL_ESTATE_AGENT("\uD83D\uDCB5"),
    LANDSCAPER("\uD83E\uDEB4"),
    POOL_MANUFACTURER("\uD83C\uDF0A"),
    TEMP_AGENCY("\uD83C\uDFD7"),
    BIS("\uD83D\uDCE7");

    private final String icon;

    Bonus(final String symbols) {
        this.icon = symbols;
    }

    public String getIcon() {
        return icon;
    }
}
