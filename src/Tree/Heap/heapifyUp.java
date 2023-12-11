package Tree.Heap;

public class heapifyUp {
    public static void swim(int[] arr, int n, int i) {
        int parent = (i - 1) / 2;

        if (parent >= 0) {
            if (arr[i] > arr[parent]) {
                int tmp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = tmp;

                swim(arr, n, parent);
            }
        }
    }
}
