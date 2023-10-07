package SortingProjects;

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
        
        for (int i = 0; i < n - 1; i ++) {
            int minIndex = i;

            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }


            int numHolder = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = numHolder;
        }
    }
}
