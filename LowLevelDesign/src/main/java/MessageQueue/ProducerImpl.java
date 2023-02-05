package MessageQueue;

public abstract class ProducerImpl implements Producer {
    private MessageQueueService messageQueueService;

    public ProducerImpl(MessageQueueService messageQueueService) {
        this.messageQueueService = messageQueueService;
    }

    @Override
    public boolean publishMessage(Message message) throws InterruptedException {
        int retries = 3;
        int count = 0;
        boolean isSuccess = false;
        while (count < retries && !isSuccess) {
            isSuccess = messageQueueService.addMessageToQueue(message);
            count++;
        }
        return isSuccess;
    }
}
