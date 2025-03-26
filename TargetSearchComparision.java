import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TargetSearchComparision {

    // Linear Search Implementation
    public static int linearSearch(int[] arr, int trgt) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == trgt) {
                // Return index if found
                return i;
            }
        }
        // Return -1 if not found
        return -1;
    }

    // Binary Search Implementation (Array must be sorted first)
    public static int binarySearch(int[] arr, int trgt) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == trgt) {
                return mid;
            }
            else if (arr[mid] < trgt) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Method to generate a random dataset of given size
    public static int[] generateDataset(int n) {
        Random rand = new Random();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            // Assigning random numbers
            data[i] = rand.nextInt(n * 10);
        }
        return data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dataset size: ");
        int n = sc.nextInt();

        int[] dataset = generateDataset(n);
        Random rand = new Random();

        // Choose a random target from the dataset
        int trgt = dataset[rand.nextInt(n)];
        System.out.println("Target to search: "+trgt);


        // Measure Linear Search Time
        long startTime = System.nanoTime();
        linearSearch(dataset, trgt);
        long endTime = System.nanoTime();
        long linearTime = endTime - startTime;

        // Sort the dataset for Binary Search
        Arrays.sort(dataset);

        // Measure Binary Search Time
        startTime = System.nanoTime();
        binarySearch(dataset, trgt);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;

        // Print Results
        System.out.println("Dataset Size: " + n);
        System.out.println("---------------------------------");
        System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
        System.out.println("---------------------------------");
        System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
        System.out.println("---------------------------------");
    }
}


/*
I/P->
Enter dataset size: 200
Target to search: 1627
O/P->
Dataset Size: 200
---------------------------------
Linear Search Time: 0.0034 ms
---------------------------------
Binary Search Time: 0.0025 ms
---------------------------------
 */