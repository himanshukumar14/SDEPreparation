package MessageQueue;

public abstract class Consumer<T> {
    public String id;

    abstract T poll();
}
