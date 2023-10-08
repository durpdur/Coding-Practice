
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

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int numHolder = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = numHolder;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}