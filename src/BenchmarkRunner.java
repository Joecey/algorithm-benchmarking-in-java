import eoj.algos.*;
import eoj.utilities.GenerateResultsCSV;
import eoj.utilities.PrintTableRow;
import eoj.utilities.TimeAlgorithm10Average;

import java.io.IOException;
import java.util.*;

public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {

        System.out.println("~~~ Algorithm Benchmarking Assignment - Joe Linogao ~~~");
        // Get user input for all n values you would like
        Scanner newScanner = new Scanner(System.in);

        // e.g. 10, 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000
        System.out.print("Enter array sizes you would like to test (e.g. 5, 10, 1000, 2500): ");
        String nValues = newScanner.nextLine();
        System.out.print("Would you like to generate a .csv file of your results (y/N)?: ");
        String generateCSVInput = newScanner.nextLine();
        boolean generateCSV = Objects.equals(generateCSVInput, "y") || Objects.equals(generateCSVInput, "Y");

        // split array by delimiter then process each to ensure that they are all valid integers
        String[] nValuesArray = nValues.replaceAll("\\s+", "").split(",");
        List<Integer> nValuesArrayInt = new ArrayList<Integer>();

        for (String nValue : nValuesArray) {
            try {
                nValuesArrayInt.add(Integer.parseInt(nValue));
            } catch (Exception err) {
                System.out.format("ERROR: %s - exiting program... \n", err.getMessage());
                System.exit(-1);
            }
        }

        // create our new algorithm classes
        ISorterForIntegers bubbleSortAlgo = new BubbleSort();
        ISorterForIntegers insertionSortAlgo = new InsertionSort();
        ISorterForIntegers selectionSortAlgo = new SelectionSort();
        ISorterForIntegers countingSortAlgo = new CountingSort();
        ISorterForIntegers mergeSortAlgo = new MergeSort();


        // create our benchmark generator class then process all our algorithms
        System.out.println("Running benchmarks... this will take some time...");
        TimeAlgorithm10Average benchmarkResultsGenerator = new TimeAlgorithm10Average(nValuesArrayInt, nValuesArray);
        benchmarkResultsGenerator.generateResultsWithAlgo("bubble", bubbleSortAlgo);
        benchmarkResultsGenerator.generateResultsWithAlgo("insertion", insertionSortAlgo);
        benchmarkResultsGenerator.generateResultsWithAlgo("selection", selectionSortAlgo);
        benchmarkResultsGenerator.generateResultsWithAlgo("counting", countingSortAlgo);
        benchmarkResultsGenerator.generateResultsWithAlgo("merge", mergeSortAlgo);

        // After we get our results, print it to the console as shown
        // loop through our results hashmap, printing a new row for each key
        System.out.println("Note: Results are displayed in milliseconds");
        PrintTableRow.displayRow("sizes", benchmarkResultsGenerator.getNValuesStringArray());
        PrintTableRow.displayRow("bubble", benchmarkResultsGenerator.getAlgoResultsMap().get("bubble"));
        PrintTableRow.displayRow("insertion", benchmarkResultsGenerator.getAlgoResultsMap().get("insertion"));
        PrintTableRow.displayRow("selection", benchmarkResultsGenerator.getAlgoResultsMap().get("selection"));
        PrintTableRow.displayRow("counting", benchmarkResultsGenerator.getAlgoResultsMap().get("counting"));
        PrintTableRow.displayRow("merge", benchmarkResultsGenerator.getAlgoResultsMap().get("merge"));

        if (generateCSV) {
            System.out.println("Generating .csv file of results...");
            // create list of rows
            List<String[]> dataLines = new ArrayList<>();
            dataLines.add(GenerateResultsCSV.combineKeyAndArray("sizes", benchmarkResultsGenerator.getNValuesStringArray()));

            for (Map.Entry<String, String[]> algoResultEntry : benchmarkResultsGenerator.getAlgoResultsMap().entrySet()) {
                dataLines.add(
                        GenerateResultsCSV.combineKeyAndArray(algoResultEntry.getKey(), algoResultEntry.getValue())
                );
            }

            // after creating our dataLines, we can now generate our CSV
            GenerateResultsCSV.createResultsCSV(dataLines);

        }

    }
}