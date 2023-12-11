package Tree.Heap;

public class handleNode {
    static void insertNode(int[] arr, int n, int key) {
        n = n + 1;
        arr[n-1] = key;
        heapifyUp.swim(arr, n, n-1);
    }

    static void deleteRoot(int[] arr, int n) {
        arr[0] = arr[n-1];
        n = n - 1;
        heapifyDown.sink(arr, n ,0);
    }
}
