import java.util.ArrayList;

public class Hashtable {
    private int size;
    private ArrayList<ArrayList<Pair>> table;

    public Hashtable(int size) {
        this.size = size;
        table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(null);
        }
    }

    private int hash_fun(String key) {
        int i = 0;
        for (char c : key.toCharArray()) {
            i += c;
        }
        int index = i % size;
        return index;
    }

    public void insert(String key, String value) {
        int index = hash_fun(key);
        if (table.get(index) == null) {
            table.set(index, new ArrayList<>());
            table.get(index).add(new Pair(key, value));
        } else {
            boolean found = false;
            for (int i = 0; i < table.get(index).size(); i++) {
                Pair element = table.get(index).get(i);
                if (element.key.equals(key)) {
                    table.get(index).set(i, new Pair(key, value));
                    found = true;
                }
            }
            if (!found) {
                table.get(index).add(new Pair(key, value));
            }
        }
    }

    public void delete(String key) {
        int index = hash_fun(key);
        ArrayList<Pair> list = table.get(index);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key.equals(key)) {
                    list.remove(i);
                    break;
                }
            }
        }
    }

    public String disp(String key) {
        int index = hash_fun(key);
        ArrayList<Pair> list = table.get(index);
        if (list != null) {
            for (Pair pair : list) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Hashtable h = new Hashtable(10);
        h.insert("name", "john");
        h.insert("age", "30");
        System.out.println(h.disp("name")); // Output: john

        h.insert("march 6", "67");
        h.insert("march 17", "66");
        System.out.println(h.table);

        h.delete("march 6");
        System.out.println(h.table);
    }

    private class Pair {
        String key;
        String value;

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
}
