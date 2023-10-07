package SortingProjects;
public class InsertionSort {
    public static void main (String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        insertionSort(arr);

        System.out.println("Sorted Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            // set key at beginning of array
            int key = arr[i];
            // set pointer at position before key
            int j = i - 1;

            // set boundary for j
            // set break condition: when the pointer is smaller than the key, meaning it should stop. 
            while (j >= 0 && arr[j] > key) {
                //shift array to the right by 1
                arr[j + 1] = arr[j];
                // do it for the whole array
                j--;
            }
            // set position after pointer as the key
            arr[j + 1] = key;
        }
        
    }
}
