public class SelectionSort {
    public static void main (String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 9};
        selectionSort(arr);

        System.out.println("Sorted array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for ( int i = 0; i < n - 1; i++) {
            int minKey = i;
            // rest of the array is i + 1 to n
            for (int j = i+1; j < n; j++) {
                // just find the smallest value in the rest of the array
                if (arr[minKey] > arr[j]) {
                    minKey = j;
                }
            }

            int numHolder = arr[i];
            arr[i] = arr[minKey];
            arr[minKey] = numHolder;
        }
    }
}
