package MessageQueue;

public abstract class Producer<T> {
    private String id;

    abstract void publish(T payload);

}
