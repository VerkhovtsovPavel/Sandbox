package my.sandbox.data_manager;

import java.util.ArrayList;
import java.util.List;

//TODO Make class thread-safety
//TODO Add methods to load and save user from/to external source
public class DataManager<T> {

    private final List<T> storedData;
    private final DataGenerator<T> generator;

    public DataManager(final DataGenerator<T> generator) {
        this.generator = generator;
        this.storedData = new ArrayList<T>();
       // this.users.add(new User("Pavel", "QW123456"));
    }

    public T getInUse() {
        if (storedData.size() == 0) {
            return generator.generate();
        }
        T user = storedData.get(0);
        storedData.remove(0);
        return user;
    }

    public void release(final T user) {
        storedData.add(user);
    }
}
