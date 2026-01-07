/// Maintains the max-heap property for a subtree rooted at index `i`.
/// `n` is the current size of the heap.
fn heapify<T: PartialOrd>(slice: &mut [T], n: usize, i: usize) {
    let mut largest = i;
    let left = 2 * i + 1;
    let right = 2 * i + 2;

    // Check if left child is within bounds and greater than root
    if left < n && slice[left] > slice[largest] {
        largest = left;
    }

    // Check if right child is within bounds and greater than current largest
    if right < n && slice[right] > slice[largest] {
        largest = right;
    }

    // If largest is not the root, swap and recurse
    if largest != i {
        slice.swap(i, largest);
        
        // Recursively heapify the affected subtree
        heapify(slice, n, largest);
    }
}

/// Main Heap Sort function.
fn heap_sort<T: PartialOrd>(slice: &mut [T]) {
    let n = slice.len();
    if n <= 1 {
        return;
    }

    // 1. Build Max Heap: Start from the last non-leaf node and move upwards
    for i in (0..n / 2).rev() {
        heapify(slice, n, i);
    }

    // 2. Extract elements from the heap one by one
    for i in (1..n).rev() {
        // Move current root (the maximum) to the end of the unsorted portion
        slice.swap(0, i);

        // Call heapify on the reduced heap (size i) starting from the root
        heapify(slice, i, 0);
    }
}

fn main() {
    let mut data = vec![12, 11, 13, 5, 6, 7];
    
    println!("Original array: {:?}", data);

    // Perform Heap Sort
    heap_sort(&mut data);

    println!("Sorted array:   {:?}", data);
}
