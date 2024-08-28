class CNode {
    int data;
    CNode next;

    public CNode(int data, CNode next) {
        this.data = data;
        this.next = next;
    }
}

class CircularLinkedList {
    CNode head;

    public void printList() {
        if (head == null) {
            System.out.println("Linked List Empty");
        }

        CNode itr = head;
        String llstr = "";
        while(itr!=null){
            llstr+=itr.data+"-->";
            itr=itr.next;
            if (itr==head){
                break;
            }

        }
        System.out.println(llstr);
    }

    public int getLength() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        CNode itr = head;
        while(itr!=null){
            itr=itr.next;
            count+=1;
            if(itr==head){
                break;
            }
        }
        return count;
    }

    public void insertAtBeginning(int data) {
        CNode node = new CNode(data, head);
        if (head == null) {
            node.next = node;
            head=node;

        }
        CNode itr=head;
        while(itr.next!=head){
            itr=itr.next;
        }
        itr.next=node;
        head=node;
    }

    public void insertAtEnd(int data) {
        CNode node = new CNode(data, head);
        if (head == null) {
            node.next = node;
            head = node;
        }
        CNode itr=head;
        while(itr.next!=head){
            itr=itr.next;
        }
        itr.next=node;

    }

    public void insertAt(int index, int data) {
        int length = getLength();

        if (index < 0 || index > length) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        if (index == length) {
            insertAtEnd(data);
            return;
        }

        int count = 0;
        CNode itr = head;
        while(itr!=null){
            if (count==index-1){
                CNode node = new CNode(data,itr.next);
                itr.next=node;
                break;
            }
            itr=itr.next;
            count+=1;
        }
    }

    public void find(int data) {
        int count = 0;
        CNode itr = head;
        while(itr!=null){
            if(itr.data==data){
                System.out.println("Index is "+count);
                break;
            }
            itr=itr.next;
            count+=1;
        }
    }

    public void insertValues(int[] dataList) {
        head = null;
        for (int data : dataList) {
            insertAtEnd(data);
        }
    }

    public void removeAt(int index) {
        int length = getLength();
        int count = 0;
        CNode itr = head;
        while(itr!=null){
            if (count==index-1){
                itr.next=itr.next.next;
                break;
            }
            itr=itr.next;
            count+=1;
        }

    }

    public void removeByValue(int data) {
        CNode itr = head;
        int count=0;
        while(itr!=null){
            if (itr.data==data){
                removeAt(count);
                break;
            }
            itr=itr.next;
            count+=1;
        }
    }

    public void removeAtBeginning() {
        removeAt(0);
    }

    public void removeAtEnd() {
        removeAt(getLength() - 1);
    }


}

public class CL {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertValues(new int[]{2, 3, 4, 5, 6, 7});
        cll.insertAtBeginning(33);
        cll.insertAtEnd(56);
        cll.insertAt(4, 43);
        cll.printList();
        cll.find(56);
        cll.removeAt(2);
        cll.printList();
        cll.removeByValue(4);
        cll.printList();
    }
}
