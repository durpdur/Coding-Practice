public class MergeSort {
    public static void main (String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 30};

        mergeSort(arr, 0, arr.length -1);

        for (int value: arr) {
            System.out.print(value + " ");
        }

    }

    public static void mergeSort(int[] arr, int l, int r) {

        if (l < r) {
            //find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Merge two subarrays of arr[]
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    // Basically the arrays are split along m
    public static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays leftArr[] and rightArr[]
        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[m + 1 + j];

        // Merge the temporary arrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArr[] if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArr[] if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
