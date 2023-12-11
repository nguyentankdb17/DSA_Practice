package Tree.Heap;

public class heapifyDown {
    public static void sink(int[] arr, int n, int i)
    {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int largest = i;

        if (left < n && arr[largest] < arr[left] ) {
            largest = left;
        }
        if (right < n && arr[largest] < arr[right] ) {
            largest = right;
        }

        if (largest != i) {
            int tmp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = tmp;
            sink(arr, n, largest);
        }
    }
}
