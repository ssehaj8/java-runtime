import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingComparison {

    // Bubble Sort: Inefficient for large datasets
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort: Efficient and stable sorting algorithm
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            }
            else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort: Fast but not always stable
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Choose last element as pivot
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Generate an array with random values
    public static int[] generateDataset(int n) {
        Random rand = new Random();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            // Generate random numbers
            data[i] = rand.nextInt(n * 10);
        }
        return data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dataset size: ");
        int n = sc.nextInt();

        // Generate dataset and create copies for different sorting algorithms
        int[] dataset1 = generateDataset(n);
        int[] dataset2 = Arrays.copyOf(dataset1, dataset1.length);
        int[] dataset3 = Arrays.copyOf(dataset1, dataset1.length);

        // calculate Bubble Sort Time
        long startTime = System.nanoTime();
        bubbleSort(dataset1);
        long endTime = System.nanoTime();
        long bubbleTime = endTime - startTime;

        // calculate Merge Sort Time
        startTime = System.nanoTime();
        mergeSort(dataset2, 0, dataset2.length - 1);
        endTime = System.nanoTime();
        long mergeTime = endTime - startTime;

        // calculate Quick Sort Time
        startTime = System.nanoTime();
        quickSort(dataset3, 0, dataset3.length - 1);
        endTime = System.nanoTime();
        long quickTime = endTime - startTime;


        System.out.println("Dataset Size: " + n);
        System.out.println("Bubble Sort Time: " + bubbleTime / 1_000_000.0 + " ms");
        System.out.println("Merge Sort Time: " + mergeTime / 1_000_000.0 + " ms");
        System.out.println("Quick Sort Time: " + quickTime / 1_000_000.0 + " ms");

    }
}


/*
I/P->
Enter dataset size: 200
O/P->
Dataset Size: 200
Bubble Sort Time: 0.809 ms
Merge Sort Time: 0.1562 ms
Quick Sort Time: 0.079 ms
 */