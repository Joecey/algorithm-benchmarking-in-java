import eoj.algos.BubbleSort;
import eoj.utilities.GenerateRandomInt;
import eoj.utilities.PrintTableRow;

import java.util.Arrays;

public class BenchmarkRunner {
    public static void main(String[] args) {

        System.out.println("~~~ Algorithm Benchmarking Assignment - Joe Linogao ~~~");
        BubbleSort bubbleSortAlgo = new BubbleSort();

        int[] testList = GenerateRandomInt.randomArray(20);
        System.out.println("To start: " + Arrays.toString(testList));

        int[] sortedList = bubbleSortAlgo.sortIntegerArray(testList);
        System.out.println("After bubble sort:" + Arrays.toString(sortedList));


        // After we get our results, print it to the console as shown
        PrintTableRow.displayRow("Bubble", new String[]{"test", "test", "test", "test",
                "test", "test", "test", "test", "test", "test",
                "test", "test", "test"});



        // TODO: Generate results as .csv

    }
}