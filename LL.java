class Node{
    int data;
    Node next;
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
class LinkedList {
    Node head;
    public void print() {
        if (head == null) {
            System.out.println("Linked list is empty");
        }
        Node itr = head;
        String llstr = "";
        while (itr != null) {
            llstr+=itr.data+"-->";
            itr = itr.next;
        }
        System.out.println(llstr);
    }
    public int getLength() {
        int count = 0;
        Node itr = head;
        while (itr != null) {
            count++;
            itr = itr.next;
        }
        return count;
    }
    public void insertAtBeginning(int data) {
        Node node = new Node(data, head);
        this.head = node;
    }
    public void insertAtEnd(int data) {
        if (head == null) {
            head = new Node(data, null);
            return;
        }
        Node itr = head;
        while (itr.next != null) {
            itr = itr.next;
        }
        itr.next = new Node(data, null);
    }
    public void insertAt(int index, int data) {
        if (index < 0 || index > getLength()) {
            System.out.println("Invalid Index");
            return;
        }
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }
        int count = 0;
        Node itr = this.head;
        while (itr != null) {
            if (count == index - 1) {
                Node node = new Node(data, itr.next);
                itr.next = node;
                break;
            }
            itr = itr.next;
            count++;
        }
    }
    public void removeAt(int index) {
        if (index < 0 || index >= getLength()) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        int count = 0;
        Node itr = head;
        while (itr != null) {
            if (count == index - 1) {
                itr.next = itr.next.next;
                break;
            }

            itr = itr.next;
            count++;
        }
    }

    public void insertValues(int[] dataArr) {
        head = null;
        for (int data : dataArr) {
            this.insertAtEnd(data);
        }
    }

    public void insertAfter(int dataAfter, int dataToInsert) {
        int count = 0;
        Node itr = head;
        while (itr != null) {
            if (itr.data == dataAfter) {
                break;
            }

            itr = itr.next;
            count++;
            if (itr == null) {
                System.out.println("Data not exist");
            }
        }

        insertAt(count + 1, dataToInsert);
    }

    public void removeByValue(int data) {
        int count = 0;
        Node itr = head;
        while (itr != null) {
            if (itr.data == data) {
                break;
            }
            itr = itr.next;
            count++;
        }
        removeAt(count);
    }
}

public class LL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertValues(new int[]{45, 7, 12, 567, 99});
        ll.print();
        ll.removeAt(2);
        ll.print();
        ll.insertAfter(7, 1);
        ll.print();
        ll.removeByValue(7);
        ll.print();
    }
}
