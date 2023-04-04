package my.sandbox.data_manager;

import java.util.List;

public interface ExternalSource<T> {

    List<T> loadStoredData();
    void save(List<T> data);

}
