package my.sandbox.welcome;

public final class Main {

    private Main() {

    }

    public static void main(final String[] args) {
        for (Bonus bonus: Bonus.values()) {
            System.out.println(bonus + " - " + bonus.getIcon());
        }
    }
}
