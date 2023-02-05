package MessageQueue;

public interface MessageQueueService {
    void addSubscriber(String regex, Consumer consumer);
    void removeSubscriber(String regex, Consumer consumer);
    boolean addMessageToQueue(Message message) throws InterruptedException;
    Message getMessageFromQueue(Consumer consumer) throws InterruptedException;
}
