class DoublyNode {
    String data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(String data, DoublyNode next, DoublyNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList {
    DoublyNode head;

    public void printForward() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        DoublyNode itr = head;
        String llstr ="";
        while (itr != null) {
            llstr+=itr.data+"-->";
            itr = itr.next;
        }
        System.out.println(llstr);
    }

    public void printBackward() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        DoublyNode lastNode = getLastNode();
        DoublyNode itr = lastNode;
        String llstr ="";
        while (itr != null){
            llstr+=itr.data+"-->";
            itr = itr.prev;
        }
        System.out.println("Link list in reverse: " + llstr);
    }

    public DoublyNode getLastNode() {
        DoublyNode itr = head;
        while (itr.next != null) {
            itr = itr.next;
        }
        return itr;
    }

    public int getLength() {
        int count = 0;
        DoublyNode itr = head;
        while (itr != null) {
            count++;
            itr = itr.next;
        }
        return count;
    }

    public void insertAtBeginning(String data) {
        if (head == null) {
            DoublyNode node = new DoublyNode(data, null, null);
            head = node;
        } else {
            DoublyNode node = new DoublyNode(data, head, null);
            head.prev = node;
            head = node;
        }
    }

    public void insertAtEnd(String data) {
        if (head == null) {
            head = new DoublyNode(data, null, null);
            return;
        }

        DoublyNode itr = head;
        while (itr.next != null) {
            itr = itr.next;
        }

        itr.next = new DoublyNode(data, null, itr);
    }

    public void insertAt(int index, String data) {
        if (index < 0 || index > getLength()) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        int count = 0;
        DoublyNode itr = head;
        while (itr != null) {
            if (count == index - 1) {
                DoublyNode node = new DoublyNode(data, itr.next, itr);
                if (node.next != null) {
                    node.next.prev = node;
                }
                itr.next = node;
                break;
            }

            itr = itr.next;
            count++;
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= getLength()) {
            throw new RuntimeException("Invalid Index");
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        int count = 0;
        DoublyNode itr = head;
        while (itr != null) {
            if (count == index) {
                itr.prev.next = itr.next;
                if (itr.next != null) {
                    itr.next.prev = itr.prev;
                }
                break;
            }

            itr = itr.next;
            count++;
        }
    }

    public void insertValues(String[] dataArr) {
        head = null;
        for (String data : dataArr) {
            insertAtEnd(data);
        }
    }

    public void removeAtBeginning() {
        removeAt(0);
    }

    public void removeAtEnd() {
        removeAt(getLength() - 1);
    }
}

public class DL {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertValues(new String[]{"banana", "mango", "grapes", "orange"});
        dll.printForward();
        dll.printBackward();
        dll.insertAtBeginning("papaya");
        dll.insertAtEnd("apple");
        dll.printForward();
        dll.insertAt(0, "jackfruit");
        dll.printForward();
        dll.insertAt(6, "dates");
        dll.printForward();
        dll.insertAt(2, "kiwi");
        dll.removeAtBeginning();
        dll.removeAtEnd();
        dll.printForward();
    }
}
