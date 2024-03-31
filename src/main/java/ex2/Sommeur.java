package ex2;
import java.util.concurrent.CountDownLatch;


public class Sommeur implements Runnable {
    private int[] array;
    private int debut;
    private int fin;
    private int[] partialSums;
    private int index;
    private CountDownLatch latch;

    public Sommeur(int[] array, int debut, int fin, int[] partialSums, int index, CountDownLatch latch) {
        this.array = array;
        this.debut = debut;
        this.fin = fin;
        this.partialSums = partialSums;
        this.index = index;
        this.latch = latch;
    }

    @Override
    public void run() {
        // Calculate the partial sum for the subrange
        int partialSum = 0;
        for (int i = debut; i < fin; i++) {
            partialSum += array[i];
        }

        // Store the partial sum in the array
        partialSums[index] = partialSum;

        // Signal that this task is completed
        latch.countDown();
    }
}