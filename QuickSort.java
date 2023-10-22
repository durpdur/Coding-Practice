public class QuickSort {
    public static void main (String[] args) {
        int[] arr = {2, 3, 5, 4, 1, 6};

        quickSort(arr, 0 , (arr.length - 1));

        System.out.println("Sorted array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }

    }

    // Recursively sorts through halves
    public static void quickSort(int[] arr, int low, int high) {

        // for when the splitting of arrays reach one element, where low would then = high
        if (low < high) {

            // calls partition for sorting and pivot setting
            int partitionIndex = partition(arr, low, high);


            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
        
    }

    // Actual "sorting" logic
    public static int partition(int[] arr, int low, int high) {
        // Sets the pivot as the right most element
        int pivot = arr[high];

        // set i as first pointer for smaller elements to be inserted;
        int i = low - 1;

        // set i to first position of the array, increasing
        // Swap smaller items (arr[j] to the left of the array)
        for ( int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i ++;

                int temp  = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // swap pivot into the position right after the smaller items
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return the pivot index so the following recursion know where to split the array in half
        return i + 1;
    }
}
