package MessageQueue;

import java.util.List;

public abstract class ConsumerImpl implements Consumer {
    MessageQueueService messageQueueService;
    String regex;
    List<Message> messageList;
    List<Consumer> predecessors;
    String name;

    @Override
    public void register() {
        messageQueueService.addSubscriber(regex, this);
    }

    @Override
    public void deregister() {
        messageQueueService.removeSubscriber(regex, this);
    }

    public void consumeMessage() {
        messageQueueService.getMessageFromQueue(this);
    }
}
