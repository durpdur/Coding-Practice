import java.util.List;

public class BubbleSort {

    public class Student {
        int mathScore;
        int languageScore;
        String firstName;
    }
    List<Student> students = new ArrayList<>()
    { 
        this.add(new Student(38, 41, "Mat")); 
        this.add(new Student(27, 33, "Mary"));
    };

    // Sort by mathScore + languageScore fist
    // if equals, sort by firstName


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

        for (int i = 0; i < n; i ++) {
            swapped = false;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}