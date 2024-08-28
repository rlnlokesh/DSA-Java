public class HashtableLinearProbing {
    private int size;
    private Pair[] table;

    public HashtableLinearProbing(int size) {
        this.size = size;
        table = new Pair[size];
    }

    private int hash_fun(String key) {
        int i = 0;
        for (char c : key.toCharArray()) {
            i += c;
        }
        return i % size;
    }

    public void insert(String key, int value) {
        int index = hash_fun(key);

        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index].value = value; // Update value if key already exists
                return;
            }
            index = (index + 1) % size;
        }

        table[index] = new Pair(key, value);
    }

    public void delete(String key) {
        int index = hash_fun(key);

        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = null;
                return;
            }
            index = (index + 1) % size;
        }
    }

    public Integer disp(String key) {
        int index = hash_fun(key);

        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % size;
        }

        return null;
    }

    public static void main(String[] args) {
        HashtableLinearProbing h = new HashtableLinearProbing(10);

        h.insert("apple", 5);
        h.insert("banana", 7);
        h.insert("orange", 9);

        System.out.println(h.disp("banana"));
        System.out.println(h.disp("apple"));
        System.out.println(h.disp("orange"));

        h.delete("banana");
        System.out.println(h.disp("banana"));
    }

    private class Pair {
        String key;
        int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
