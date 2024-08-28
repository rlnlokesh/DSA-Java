public class BinarySearch {

    // Iterative binary search function
    static int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if x is present at mid
            if (arr[mid] == x)
                return mid;

            // If x greater, ignore left half
            if (arr[mid] < x)
                left = mid + 1;

                // If x is smaller, ignore right half
            else
                right = mid - 1;
        }

        // If we reach here, then element was not present
        return -1;
    }

    // Recursive binary search function
    static int binarySearchRecursive(int[] arr, int x, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            // If the element is present at the middle
            if (arr[mid] == x)
                return mid;

            // If the element is smaller than mid, then it can only be present in the left subarray
            if (arr[mid] > x)
                return binarySearchRecursive(arr, x, left, mid - 1);

            // Else the element can only be present in the right subarray
            return binarySearchRecursive(arr, x, mid + 1, right);
        }

        // If the element is not present in the array
        return -1;
    }

    // Utility function to print the index of the found element or -1 if not found
    static void printSearchResult(int index) {
        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found in the array");
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int x = 10;

        // Iterative binary search
        int result = binarySearch(arr, x);
        System.out.println("Iterative Binary Search:");
        printSearchResult(result);

        // Recursive binary search
        int resultRecursive = binarySearchRecursive(arr, x, 0, arr.length - 1);
        System.out.println("Recursive Binary Search:");
        printSearchResult(resultRecursive);
    }
}
