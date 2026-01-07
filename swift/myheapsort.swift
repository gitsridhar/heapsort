import Foundation

/**
 Recursively maintains the Max-Heap property for a subtree.
 - Parameters:
   - array: The array being sorted (passed by reference).
   - n: The size of the current heap.
   - i: The index of the root of the subtree to heapify.
 */
func heapify<T: Comparable>(_ array: inout [T], _ n: Int, _ i: Int) {
    var largest = i       // Initialize largest as root
    let left = 2 * i + 1  // Left child index
    let right = 2 * i + 2 // Right child index

    // If left child is larger than root
    if left < n && array[left] > array[largest] {
        largest = left
    }

    // If right child is larger than the current largest
    if right < n && array[right] > array[largest] {
        largest = right
    }

    // If largest is not root, swap and continue heapifying
    if largest != i {
        array.swapAt(i, largest)

        // Recursively heapify the affected sub-tree
        heapify(&array, n, largest)
    }
}

/**
 Main function to perform Heap Sort.
 */
func heapSort<T: Comparable>(_ array: inout [T]) {
    let n = array.count

    // 1. Build Max Heap (Rearrange array)
    // Start from the last non-leaf node and move upwards
    for i in stride(from: n / 2 - 1, through: 0, by: -1) {
        heapify(&array, n, i)
    }

    // 2. Extract elements from heap one by one
    for i in stride(from: n - 1, through: 1, by: -1) {
        // Move current root to the end (the sorted portion)
        array.swapAt(0, i)

        // Call heapify on the reduced heap
        heapify(&array, i, 0)
    }
}

// MARK: - Main Execution
func main() {
    var data = [12, 11, 13, 5, 6, 7]
    
    print("Original Array: \(data)")
    
    heapSort(&data)
    
    print("Sorted Array:   \(data)")
}

// Invoke the driver code
main()
