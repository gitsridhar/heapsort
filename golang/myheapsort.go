package main

import "fmt"

// heapify recursively maintains the max-heap property.
// n is the size of the heap, and i is the index of the current root.
func heapify(arr []int, n int, i int) {
	largest := i
	left := 2*i + 1
	right := 2*i + 2

	// Check if left child is larger than current root
	if left < n && arr[left] > arr[largest] {
		largest = left
	}

	// Check if right child is larger than current largest
	if right < n && arr[right] > arr[largest] {
		largest = right
	}

	// If the largest is not the root, swap and continue heapifying
	if largest != i {
		arr[i], arr[largest] = arr[largest], arr[i]

		// Recursively heapify the affected sub-tree
		heapify(arr, n, largest)
	}
}

// HeapSort performs the main sorting logic.
func HeapSort(arr []int) {
	n := len(arr)

	// 1. Build Max Heap: Start from the last non-leaf node and move up
	for i := n/2 - 1; i >= 0; i-- {
		heapify(arr, n, i)
	}

	// 2. Extract elements from heap one by one
	for i := n - 1; i > 0; i-- {
		// Move the current root (maximum) to the end of the slice
		arr[0], arr[i] = arr[i], arr[0]

		// Call heapify on the reduced heap
		heapify(arr, i, 0)
	}
}

func main() {
	data := []int{12, 11, 13, 5, 6, 7}
	fmt.Printf("Original slice: %v\n", data)

	HeapSort(data)

	fmt.Printf("Sorted slice:   %v\n", data)
}
