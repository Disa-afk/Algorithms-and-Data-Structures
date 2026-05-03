import java.util.Scanner;

public class MedianCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = scanner.nextInt();
        int[] dataset = new int[size];

        for (int i = 0; i < size; i++) {
            dataset[i] = scanner.nextInt();
        }

        sortDataset(dataset);
        System.out.println("Median: " + dataset[size / 2]);
    }

    public static void sortDataset(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}