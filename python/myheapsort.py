def heapify(arr, n, i):
    """
    Recursively maintains the max-heap property.
    :param arr: The list representing the binary heap.
    :param n: Size of the current heap.
    :param i: The index of the subtree root to heapify.
    """
    largest = i       # Assume the current root is the largest
    left = 2 * i + 1  # Index of the left child
    right = 2 * i + 2 # Index of the right child

    # Check if left child exists and is greater than the current largest
    if left < n and arr[left] > arr[largest]:
        largest = left

    # Check if right child exists and is greater than the current largest
    if right < n and arr[right] > arr[largest]:
        largest = right

    # If the largest is not the root, swap and recurse
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # In-place swap

        # Recursively heapify the affected sub-tree
        heapify(arr, n, largest)

def heap_sort(arr):
    """
    Main function to perform heap sort.
    """
    n = len(arr)

    # 1. Build a Max-Heap: Start from the last non-leaf node and move up
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # 2. Extract elements one by one from the heap
    for i in range(n - 1, 0, -1):
        # Swap the current max (root) with the last element
        arr[i], arr[0] = arr[0], arr[i]

        # Call heapify on the reduced heap to restore max-heap property
        heapify(arr, i, 0)

def main():
    """Driver code to test the Heap Sort algorithm."""
    data = [12, 11, 13, 5, 6, 7]
    
    print(f"Original Array: {data}")
    
    # Sort the array in-place
    heap_sort(data)
    
    print(f"Sorted Array:   {data}")

if __name__ == "__main__":
    main()
