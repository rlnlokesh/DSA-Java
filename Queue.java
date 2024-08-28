class Queuee {
    public String[] items;
    public int size;
    public int rear;
    public int front;

    public Queuee(int size) {
        items = new String[size];
        front = rear = 0;
        size = 0; // Corrected initialization
    }

    public boolean isempty() {
        return size == 0; // Corrected condition
    }

    public boolean isfull(){
        return size == items.length;
    }

    public void enqueue(String val) {
        items[rear] = val;
        rear = (rear + 1) % items.length;
        size++;
    }

    public String dequeue() {
        String a = items[front];
        front = (front + 1) % items.length;
        size--;
        return a;
    }

    public void printt() {
        for (int i = front; i < front + size; i++) {
            System.out.print(items[i % items.length] + " ");
        }
        System.out.println();
    }

    public String front() {
        return items[front];
    }
}

public class Queue {
    public static void main(String[] args) {
        Queuee q = new Queuee(5);
        q.enqueue("3");
        q.enqueue("4");
        q.enqueue("5");
        q.enqueue("6");
        q.enqueue("7");
        q.printt();
        q.dequeue();
        q.printt();
    }
}
