package my.sandbox.user_manager;

import java.util.ArrayList;
import java.util.List;

//TODO Make class thread-safety
//TODO Add methods to load and save user from/to external source
public class UserManager {

    private static final UserManager INSTANCE = new UserManager(new UserGenerator());

    private final List<User> users;
    private final UserGenerator generator;

    public UserManager(final UserGenerator userGenerator) {
        this.generator = userGenerator;
        this.users = new ArrayList<User>();
        this.users.add(new User("Pavel", "QW123456"));
    }

    public static UserManager getInstance() {
        return INSTANCE;
    }

    public User getInUse() {
        if (users.size() == 0) {
            return generator.generateUser();
        }
        User user = users.get(0);
        users.remove(0);
        return user;
    }

    public void release(final User user) {
        users.add(user);
    }
}
