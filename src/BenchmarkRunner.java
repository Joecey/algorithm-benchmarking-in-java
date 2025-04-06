import eoj.algos.BubbleSort;
import eoj.utilities.GenerateRandomInt;

import java.util.Arrays;

public class BenchmarkRunner {
    public static void main(String[] args) {

        System.out.println("~~~ Algorithm Benchmarking Assignment - Joe Linogao ~~~");
        BubbleSort bubbleSortAlgo = new BubbleSort();

        int[] testList = GenerateRandomInt.randomArray(10);

        int[] sortedList = bubbleSortAlgo.sortIntegerArray(testList);
        System.out.println(Arrays.toString(sortedList));

    }
}