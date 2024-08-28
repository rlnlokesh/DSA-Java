class Stackk{
    public String[] items;
    public int top;

    public Stackk(int capacity) {
        this.items = new String[capacity];
        this.top = -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() { return top == items.length; }

    public void push(String item) {
        items[++top] = item;
    }

    public String pop() {
        String a= items[top];
        top--;
        return a;
    }

    public String peek() {
        return items[top];
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        for (int i = 0; i <= top; i++){
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

public class Stack{
    public static String reverse(String str) {
        int length = str.length();
        Stackk st = new Stackk(length);
        StringBuilder reversed = new StringBuilder();

        for (int i = 0; i < length; i++) {
            st.push(String.valueOf(str.charAt(i)));
        }

        while (!st.isEmpty()) {
            reversed.append(st.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        Stackk s = new Stackk(10);
        System.out.println(reverse("lokesh"));
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.pop();
        s.display();
    }
}

