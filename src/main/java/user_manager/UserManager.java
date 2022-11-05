package user_manager;

import java.util.ArrayList;
import java.util.List;

public final class UserManager {

    private static final UserManager INSTANCE = new UserManager();

    private final List<User> users;

    private UserManager() {
        users = new ArrayList<User>();
        users.add(new User("Pavel", "QW123456"));
    }

    public static UserManager getInstance() {
        return INSTANCE;
    }

    public User getInUse() {
        if (users.size() == 0) {
            return null;
        }
        User user = users.get(0);
        users.remove(0);
        return user;
    }

    public void release(final User user) {
        users.add(user);
    }
}
