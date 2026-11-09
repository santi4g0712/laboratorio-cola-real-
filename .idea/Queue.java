public class Queue implements QueueInterface {
    private QueueNode head;
    private QueueNode tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Object extract() {
        if (isEmpty()) {
            return null;
        }
        Object item = head.getItem();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return item;
    }

    @Override
    public boolean insert(Object object) {
        QueueNode newNode = new QueueNode(object);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean insert(Object object, int prioridad) {
        QueueNode newNode = new QueueNode(object, prioridad);

        if (isEmpty() || prioridad < head.getPriority()) {
            newNode.setNext(head);
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            QueueNode current = head;
            while (current.getNext() != null && current.getNext().getPriority() <= prioridad) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) {
                tail = newNode;
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
        QueueNode current = head;
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
        QueueNode current = head;
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
}
