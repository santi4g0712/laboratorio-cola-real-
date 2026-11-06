public class Queue public class Queue implements QueueInterface {
    private QueueNode front;
    private QueueNode rear;
    private int size;

    // Constructor
    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public Object extract() {
        if (isEmpty()) {
            return null;
        }
        Object item = front.getItem();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    @Override
    public boolean insert(Object object) {
        QueueNode newNode = new QueueNode(object);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean insert(Object object, int prioridad) {

        QueueNode newNode = new QueueNode(object, prioridad);

        if (isEmpty() || prioridad < front.getPriority()) {
            newNode.setNext(front);
            front = newNode;
            if (rear == null) {
                rear = newNode;
            }
        } else {
            QueueNode current = front;
            while (current.getNext() != null && current.getNext().getPriority() <= prioridad) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) {
                rear = newNode;
            }
        }
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean search(Object object) {
        QueueNode current = front;
        while (current != null) {
            if (current.getItem().equals(object)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        QueueNode current = front;
        while (current != null) {
            sb.append(current.getItem());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
} {

    QueueNode head;
    QueueNode tail;
    int size = 0;
    boolean isPriorityQueue;
}
