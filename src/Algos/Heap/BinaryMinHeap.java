package Algos.Heap;

public class BinaryMinHeap {
    int[] harr;
    int capacity;
    int heap_size;

    BinaryMinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    //Function to extract minimum value in heap and then to store
    //next minimum value at first index.
    int extractMin() {
        if (heap_size < 1)
            return -1;

        int min = harr[adjustI(1)];
        harr[adjustI(1)] = harr[adjustI(heap_size)];
        heap_size--;
        minHeapify(harr, 1, heap_size);

        return min;
    }

    //Function to insert a value in Heap.
    // 1-based index
    void insertKey(int k) {
        if (heap_size >= capacity)
            return;

        heap_size++;
        harr[adjustI(heap_size)] = k;

        // Heapify in reverse
        int i = heap_size;
        int baap = i % 2==0? i/2: (i-1)/2;
        while (baap > 0 && harr[adjustI(baap)] > harr[adjustI(i)]) {
            swap(harr, adjustI(baap), adjustI(i));

            i = baap;
            baap = i % 2==0? i/2: (i-1)/2;
        }
    }

    //Function to delete a key at ith index.
    // 0-based index
    void deleteKey(int i) {
        if (heap_size < 1 || i >= heap_size || i < 0)
            return;

        harr[i] = harr[adjustI(heap_size)];
        heap_size--;

        minHeapify(harr, i+1, heap_size); // i+1 to accommodate 0-based to 1-based call.
    }

    // 1-based index.
    private void minHeapify(int[] arr, int i, int size) {
        int minimum = i;
        int left = 2*i;
        int right = 2*i+1;

        if (left <= size && arr[adjustI(left)] < arr[adjustI(minimum)]) {
            minimum = left;
        }

        if (right <= size && arr[adjustI(right)] < arr[adjustI(minimum)]) {
            minimum = right;
        }

        if (minimum != i) {
            swap(arr, adjustI(i), adjustI(minimum));
            minHeapify(arr, minimum, size);
        }
    }

    // To handle 1-based index
    private int adjustI(int index) {
        return index - 1;
    }

    // zero-based index
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
