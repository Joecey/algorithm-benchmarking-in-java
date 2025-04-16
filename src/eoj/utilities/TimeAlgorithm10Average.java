package eoj.utilities;

import eoj.algos.ISorterForIntegers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeAlgorithm10Average {
    // Initializers variables for TimeAlgorithm10Average
    int REPEAT_ALGO_COUNT = 10;
    List<Integer> nValuesIntArray;
    String[] nValuesStringArray;
    // map each algorithm to a millisecond average for each n value
    Map<String, String[]> algoResultsMap = new HashMap<String, String[]>();

    public TimeAlgorithm10Average(List<Integer> nValuesIntArray, String[] nValuesStringArray) {
        this.nValuesIntArray = nValuesIntArray;
        this.nValuesStringArray = nValuesStringArray;
    }

    // Here we want to pass in our algorithm, run it 10 times while timing it, then return the average time
    // with this average time, append it to the hashmap double array on the corresponding key
    public void generateResultsWithAlgo(String algoKey, ISorterForIntegers algorithm) {
        for (int nValue : nValuesIntArray) {
            String averageTimeForNValue = runAlgorithmAndTime(algorithm, nValue);

            if (algoResultsMap.get(algoKey) == null) {
                algoResultsMap.put(algoKey, new String[]{averageTimeForNValue});
            } else {
                // get the existing array, copy values, then add new value to the end
                String[] temp = algoResultsMap.get(algoKey);
                String[] newList = new String[temp.length + 1];
                System.arraycopy(temp, 0, newList, 0, temp.length);
                newList[temp.length] = averageTimeForNValue;
                algoResultsMap.put(algoKey, newList);
            }

        }

    }

    private String runAlgorithmAndTime(ISorterForIntegers algorithm, int arraySize) {
        double totalTime = 0.0d;

        for (int run = 0; run < REPEAT_ALGO_COUNT; run++) {
            int[] randomisedArray = GenerateRandomInt.randomArray(arraySize);
            long startTime = System.nanoTime();
            int[] sortedArray = algorithm.sortIntegerArray(randomisedArray);
            long endTime = System.nanoTime();

            for (int i = 0; i < sortedArray.length-1; i++) {
                // Ideally, this should never happen! But adding this to be safe
                if ((sortedArray[i] > sortedArray[i + 1])) {
                    System.out.println("ERROR: Array not sorted! Kill program...");
                    System.exit(-1);
                }
            }

            // once we time this iteration, we add it to the total time
            totalTime += (double) (endTime - startTime);

        }
        // returning as a string so i can format it nicely - convert to milliseconds
        return String.format("%.3f", (totalTime / REPEAT_ALGO_COUNT) / 1000);
    }

    public List<Integer> getNValuesIntArray() {
        return nValuesIntArray;
    }

    public String[] getNValuesStringArray() {
        return nValuesStringArray;
    }

    public Map<String, String[]> getAlgoResultsMap() {
        return algoResultsMap;
    }
}
