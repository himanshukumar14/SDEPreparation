package MessageQueue;

public interface MessageQueueService {
    void addSubscriber(String regex, Consumer consumer);
    void removeSubscriber(String regex, Consumer consumer);
}
