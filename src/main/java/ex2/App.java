package ex2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;


public class App {
    public static void main(String[] args) {
        // Create an array of integers
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Define the number of threads (for simplicity, we use the number of available processors)
        int numThreads = Runtime.getRuntime().availableProcessors();

        // Calculate the size of each subrange
        int subrangeSize = array.length / numThreads;

        // Create a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Create a CountDownLatch with a count equal to the number of threads
        CountDownLatch latch = new CountDownLatch(numThreads);

        // Initialize the start and end indices of the subrange
        int start = 0;
        int end = subrangeSize;

        // Store the partial sums calculated by each Sommeur instance
        int[] partialSums = new int[numThreads];

        // Submit tasks to the thread pool
        for (int i = 0; i < numThreads; i++) {
            // For the last subrange, adjust the end index to cover the remaining elements
            if (i == numThreads - 1) {
                end = array.length;
            }

            // Create and submit a task to the thread pool
            Sommeur sommeur = new Sommeur(array, start, end, partialSums, i, latch);
            executor.submit(sommeur);

            // Update the start and end indices for the next subrange
            start = end;
            end = Math.min(end + subrangeSize, array.length);
        }

        try {
            // Wait for all tasks to complete
            latch.await();

            // Calculate the total sum by aggregating the partial sums
            int totalSum = 0;
            for (int sum : partialSums) {
                totalSum += sum;
            }

            // Print the total sum
            System.out.println("Total sum: " + totalSum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
