package my.sandbox.data_manager;

import java.util.Random;

public class UserGenerator implements DataGenerator<User>{

    private final Random rand = new Random();

    public User generate() {
        return new User(rand.nextLong() + "", rand.nextLong() + "");
    }
}
