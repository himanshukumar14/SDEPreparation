package MessageQueue;

public class Node {
    private Message message;
    public Node next;

    public Node(Message msg){
        this.message = msg;
        this.next = null;
    }

    public Message getMessage() {
        return message;
    }
}
