package MessageQueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MessageQueueServiceImpl implements MessageQueueService {
    private Map<String, Set<Consumer>> subscribersMap;
    private Map<Consumer, MessageQueue> messageQueueMap;
    private int queueCapacity;

    public MessageQueueServiceImpl() {
        this.subscribersMap = new HashMap<>();
        this.messageQueueMap = new HashMap<>();
        this.queueCapacity = queueCapacity;
    }

    @Override
    public void addSubscriber(String regex, Consumer consumer) {
        Set<Consumer> consumers = subscribersMap.getOrDefault(regex, new HashSet<>());
        consumers.add(consumer);
        subscribersMap.put(regex, consumers);
        System.out.println("Subscribed consumer: " + consumer.getName() + " for regex: " + regex);
    }

    @Override
    public void removeSubscriber(String regex, Consumer consumer) {
        if (subscribersMap.containsKey(regex)) {
            Set<Consumer> consumers = subscribersMap.get(regex);
            consumers.remove(consumer);
            subscribersMap.put(regex, consumers);
            System.out.println("Unsubscribed consumer: " + consumer.getName() + " for regex: " + regex);
        } else {
            System.out.println("No subscription exists for regex: " + regex);
        }
    }

    @Override
    public boolean addMessageToQueue(Message message) throws InterruptedException {
        boolean isSuccess = true;
        if (isSuccess) {
            String regex = message.getRegex();
            if (subscribersMap.containsKey(regex)) {
                Set<Consumer> consumers = subscribersMap.get(regex);
                for (Consumer consumer : consumers) {
                    addMessageToConsumerQueue(message, consumer);
                }
            }
        }
        return isSuccess;
    }

    private void addMessageToConsumerQueue(Message message, Consumer consumer) throws InterruptedException {
        MessageQueue messageQueue = messageQueueMap.getOrDefault(consumer, new MessageQueue(queueCapacity));
        messageQueue.add(message);
        messageQueueMap.put(consumer, messageQueue);
    }

    @Override
    public Message getMessageFromQueue(Consumer consumer) throws InterruptedException {
        MessageQueue messageQueue = messageQueueMap.get(consumer);
        return messageQueue.poll();
    }
}
