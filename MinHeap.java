import java.util.ArrayList;
import java.util.List;

class MinHeapex {
    public List<Integer> heap;

    public MinHeapex() { heap = new ArrayList<>();
    }

    public void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) < heap.get(parentIndex)) {
                int a = heap.get(index);
                heap.set(index,heap.get(parentIndex));
                heap.set(parentIndex,a);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(smallest)) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallest)) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            int temp = heap.get(index);
            heap.set(index, heap.get(smallest));
            heap.set(smallest, temp);
            heapifyDown(smallest);
        }
    }

    public int extractMin() {
        if (heap.isEmpty()) {
            return -1; // or throw an exception
        }

        int minValue = heap.get(0);
        int lastIndex = heap.size() - 1;

        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        heapifyDown(0);

        return minValue;
    }

    public void deleteNode(int value) {
        int index = heap.indexOf(value);
        int lastIndex = heap.size() - 1;
        heap.set(index, heap.get(lastIndex));
        heap.remove(lastIndex);
        heapifyDown(index);
    }

    public void display() {
        System.out.print("Min Heap: ");
        for (int value : heap) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}

class MinHeap {
    public static void main(String[] args) {
        MinHeapex minHeap = new MinHeapex();

        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(9);
        minHeap.insert(5);
        minHeap.insert(2);

        minHeap.display();  // Output: Min Heap: 2 4 3 5 9

        int minVal = minHeap.extractMin();
        System.out.println("Extracted min value: " + minVal);  // Output: Extracted min value: 2

        minHeap.display();  // Output: Min Heap: 3 4 9 5

        minHeap.deleteNode(4);
        minHeap.display();  // Output: Min Heap: 3 5 9
    }
}
