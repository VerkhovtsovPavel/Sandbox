package user_manager;

import java.util.Random;

public class UserGenerator {

    private final Random rand = new Random();

    public User generateUser() {
        return new User(rand.nextLong()+ "", rand.nextLong()+ "");
    }
}
