package MessageQueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QueueServiceImpl implements MessageQueueService {

    private Map<String, Set<Consumer>> suscribersMap;

    public QueueServiceImpl() {
        suscribersMap = new HashMap<>();
    }

    @Override
    public void addSubscriber(String regex, Consumer consumer) {
        Set<Consumer> consumers = suscribersMap.getOrDefault(regex, new HashSet<>());
        consumers.add(consumer);
        suscribersMap.put(regex, consumers);
        System.out.println("Subscribed consumer: " + consumer.getName() + " for regex: " + regex);
    }

    @Override
    public void removeSubscriber(String regex, Consumer consumer) {
        if (suscribersMap.containsKey(regex)) {
            Set<Consumer> consumers = suscribersMap.get(regex);
            consumers.remove(consumer);
            suscribersMap.put(regex, consumers);
            System.out.println("Unsubscribed consumer: " + consumer.getName() + " for regex: " + regex);
        } else {
            System.out.println("No subscription exists for regex: " + regex);
        }
    }
}
