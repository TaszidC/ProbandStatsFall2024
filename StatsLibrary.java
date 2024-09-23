import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StatsLibrary {

    //  mean
    public double findMean(int[] numbers) {
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }

    // median
    public double findMedian(int[] numbers) {
        Arrays.sort(numbers);
        int middle = numbers.length / 2;
        if (numbers.length % 2 == 0) {
            return (numbers[middle - 1] + numbers[middle]) / 2.0;
        } else {
            return numbers[middle];
        }
    }

    // Method to find the mode
    public int findMode(int[] numbers) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int mode = numbers[0];
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }

    //standard deviation
    public double findStandardDeviation(int[] numbers) {
        double mean = findMean(numbers);
        double sumSquaredDifferences = 0;
        for (int num : numbers) {
            sumSquaredDifferences += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sumSquaredDifferences / numbers.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StatsLibrary stats = new StatsLibrary();

        while (true) {
            System.out.println("Enter the number of elements:");
            int n = scanner.nextInt();
            int[] data = new int[n];

            System.out.println("Enter the numbers:");
            for (int i = 0; i < n; i++) {
                data[i] = scanner.nextInt();
            }

            System.out.println("Mean: " + stats.findMean(data));
            System.out.println("Median: " + stats.findMedian(data));
            System.out.println("Mode: " + stats.findMode(data));
            System.out.println("Standard Deviation: " + stats.findStandardDeviation(data));

            System.out.println("Do you want to enter another set of numbers? (yes/no)");
            scanner.nextLine(); 
            String response = scanner.nextLine();

            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }
}
