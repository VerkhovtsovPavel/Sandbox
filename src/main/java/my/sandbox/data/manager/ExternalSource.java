package my.sandbox.data.manager;

import java.util.List;

public interface ExternalSource<T> {

    List<T> loadStoredData();
    void save(List<T> data);

}
