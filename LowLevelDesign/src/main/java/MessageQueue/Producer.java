package MessageQueue;

public interface Producer {
    boolean publishMessage(Message message) throws InterruptedException;
}
