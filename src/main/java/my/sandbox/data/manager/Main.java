package my.sandbox.data.manager;

public class Main {

    public static void main(final String[] args) {
        DataManager<User> manager = new DataManager<User>(new UserGenerator());
        User[] users = new User[25];
        for (int i = 0; i < 10; i++) {
            users[i] = manager.getInUse();
            System.out.println(users[i]);
        }

        for (int i = 0; i < 10; i++) {
            manager.release(users[i]);
        }

        for (int i = 0; i < 25; i++) {
            users[i] = manager.getInUse();
            System.out.println(users[i]);
        }
    }
}
