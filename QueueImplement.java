import sun.awt.image.ImageWatched;

public class QueueImplement {
    class LinkedList {
        int key;
        LinkedList next;

        LinkedList(int ds) {
            this.key = ds;
            this.next = null;
        }
    }

    LinkedList root;
    int capacity;

    QueueImplement(int c) {
        this.capacity = c;
        root = new LinkedList(0);
    }

    public boolean enQueue(int s) {
        LinkedList current = root;
        int length = count(current);
        System.out.println("length- "+ length);
        if (length >= capacity) {
            return false;
        }
        LinkedList newNode = new LinkedList(s);
        LinkedList fast = root.next;
        current.next = newNode;
        newNode.next = fast;
        return true;
    }

    public int count(LinkedList root) {
        LinkedList current = root.next;
        int length = 0;
        if (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    public boolean deQueue() {
        LinkedList current = root;
        int counts = count(current);
        if (counts == 0) {
            return false;
        }
        current.next = current.next.next;
        return true;
    }

    public int front() {
        LinkedList current = root;
        if (current.next != null) {
            return current.next.key;
        }
        return -1;
    }

    public int rear() {
        LinkedList current = root;
        if(current.next!=null){
            return current.next.key;
        }
        return -1;
    }

    public boolean isEmpty() {
        LinkedList current = root.next;
        int length = 0;
        if (current == null) {
            return true;
        }
        while (current != null) {
            current = current.next;
            length++;
        }
        if (length > 0) {
            return false;
        }
        return true;
    }

    public boolean isFull() {
        LinkedList current = root;
        int length = count(current);
        if (length == capacity) {
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        QueueImplement obj = new QueueImplement(3);
       boolean one = obj.enQueue(1);
        boolean two = obj.enQueue(2);
      boolean three =   obj.enQueue(3);
       boolean four =  obj.enQueue(4);
       int rea=  obj.rear();
      boolean full =  obj.isFull();
        boolean deq = obj.deQueue();
       boolean enq = obj.enQueue(4);
      int rear =   obj.rear();
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
        System.out.println(rea);
        System.out.println(full);
        System.out.println(deq);
        System.out.println(enq);
        System.out.println(rear);

    }
}
