public class BubbleSort {
    public static void main (String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);

        System.out.println("Sorted array is: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // iterates through the array, n-1 to account for i = 0
        for (int i = 0; i < n - 1; i++) {
            // swapped is set to false until a swap is needed, where swap is set to true
            swapped = false;

            //n - i - 1 is because the last position is alreay sorted, so j should sort one less each time it loops
            for (int j = 0; j < n - i - 1; j++) {
                if ( arr[j] > arr[j + 1]) {
                    // temp is a temporary variable used to store the first position
                    int temp = arr[j];
                    // arr[j] and arr[j + 1] is swapped
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    // swapped is set to true, as a swap occured
                    swapped = true;
                }
            }
            // if no swap occured, swapped = false, the whole thing breaks(stops)!
            if (!swapped) {
                break;
            }
        }
    }
}