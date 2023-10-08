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

        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            System.out.println("PartitionIndex: " + partitionIndex);
            for (int value: arr) {
                System.out.print(value + " ");
            }
            System.out.println();
            System.out.println("=========================");

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
        
    }

    // Actual "sorting" logic
    public static int partition(int[] arr, int low, int high) {
        // sets the limits for the sections of sorts going on
        int pivot = arr[high];
        int i = low - 1;
        System.out.println("Pivot: " + pivot);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
