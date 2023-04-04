package my.sandbox.data_manager.allocation;

import my.sandbox.data_manager.allocation.exception.EmptyDataPollException;

//TODO Add exception generification
public class ExceptionStrategy<T> implements AllocationStrategy<T> {

    @Override
    public T processUseRequest() {
        throw new EmptyDataPollException();
    }
}
