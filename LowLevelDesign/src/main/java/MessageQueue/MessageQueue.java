package MessageQueue;

public class MessageQueue {
    private Node front;
    private Node rear;
    private int capacity;
    private int size;
    private Object lock = new Object();

    public MessageQueue(int capacity) {
        this.front = null;
        this.rear = null;
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void add(Message msg) throws InterruptedException {
        synchronized (lock) {
            while (isFull()) {
                lock.wait();
            }
            Node node = new Node(msg);
            if (front == null) {
                front = node;
            } else {
                rear.next = node;
            }
            size++;
            rear = node;
            System.out.println("Message added-" + msg.getPayload());
            lock.notify();
        }
    }

    public Message poll() throws InterruptedException {
        synchronized (lock) {
            while (isEmpty()) {
                lock.wait();
            }
            Node node = this.front;
            if (front == rear) {
                front = null;
                rear = null;
            } else {
                front = front.next;
            }
            size--;
            System.out.println("Message removed-" + node.getMessage().getPayload());
            lock.notify();
        }
    }

    public int getSize() {
        return size;
    }
}
