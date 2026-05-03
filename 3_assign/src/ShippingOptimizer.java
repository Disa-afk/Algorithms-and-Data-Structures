import java.util.Scanner;

public class ShippingOptimizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of packages: ");
        int count = scanner.nextInt();
        int[] packageWeights = new int[count];

        int maxWeight = 0;
        int totalWeight = 0;

        System.out.println("Enter weights:");
        for (int i = 0; i < count; i++) {
            packageWeights[i] = scanner.nextInt();
            if (packageWeights[i] > maxWeight) maxWeight = packageWeights[i];
            totalWeight += packageWeights[i];
        }

        System.out.print("Enter available days: ");
        int daysLimit = scanner.nextInt();

        System.out.println("Optimal Capacity: " + findMinimumCapacity(packageWeights, daysLimit, maxWeight, totalWeight));
    }

    public static int findMinimumCapacity(int[] weights, int days, int low, int high) {
        int result = high;

        while (low <= high) {
            int midCapacity = low + (high - low) / 2;

            if (canShipWithinDays(weights, days, midCapacity)) {
                result = midCapacity;
                high = midCapacity - 1;
            } else {
                low = midCapacity + 1;
            }
        }
        return result;
    }

    public static boolean canShipWithinDays(int[] weights, int daysLimit, int capacity) {
        int currentDaysUsed = 1;
        int currentDailyLoad = 0;

        for (int weight : weights) {
            if (currentDailyLoad + weight > capacity) {
                currentDaysUsed++;
                currentDailyLoad = weight;
            } else {
                currentDailyLoad += weight;
            }
        }
        return currentDaysUsed <= daysLimit;
    }
}