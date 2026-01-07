import java.util.Arrays;

public class RecursiveHeapSort {

    /**
     * Main function to perform Heap Sort.
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. Build Max Heap: Rearrange the array
        // Start from the last non-leaf node and move upwards
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end (the sorted portion)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call recursive heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * Recursively maintains the Max Heap property.
     * @param arr The array representing the heap.
     * @param n   Size of the heap.
     * @param i   The index of the root of the sub-tree.
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // left child index
        int right = 2 * i + 2; // right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6, 7};

        System.out.println("Original Array: " + Arrays.toString(data));

        heapSort(data);

        System.out.println("Sorted Array:   " + Arrays.toString(data));
    }
}
