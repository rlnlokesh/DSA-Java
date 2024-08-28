import java.util.ArrayList;
import java.util.List;

class MaxHeapex {
    public ArrayList<Integer> heap;

    public MaxHeapex() {
        heap = new ArrayList<>();
    }

    public void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) > heap.get(parentIndex)) {
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
        int largest = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(largest)) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largest)) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            int temp = heap.get(index);
            heap.set(index, heap.get(largest));
            heap.set(largest, temp);
            heapifyDown(largest);
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
        System.out.print("Max Heap: ");
        for (int value : heap) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}

class MaxHeap {
    public static void main(String[] args) {
        MaxHeapex maxHeap = new MaxHeapex();

        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(5);
        maxHeap.insert(2);

        maxHeap.display();

        int minVal = maxHeap.extractMin();
        System.out.println("Extracted max value: " + minVal);

        maxHeap.display();

        maxHeap.deleteNode(4);
        maxHeap.display();
    }
}
