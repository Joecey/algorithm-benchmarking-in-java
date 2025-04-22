package eoj.algos;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class CountingSort implements ISorterForIntegers {
    @Override
    public int[] sortIntegerArray(int[] array) {
        return beginCountingSort(array);
    }
    // use sortedMap so that keys are automatically sorted
    /*
    * // This is an example of a NON-COMPARISON SORT
     * create a map of keys which will include every distinct value in list
     * the keys will be sorted using a sortedMap
     * new array with size n
     * go through the list and count the number of times each value appears
     * then iterate through the keys - k, adding the key value equal to the number
     * of times it appears in list
     */

    private int[] beginCountingSort(int[] array) {
        int[] result = new int[array.length];
        int resultIdx = 0;
        // TreeMap is a type of SortedMap
        SortedMap<Integer, Integer> countedElements = new TreeMap<>();
        for (int value : array) {
            if (countedElements.containsKey(value)) {
                countedElements.put(value, 1 + countedElements.get(value));
            } else {
                countedElements.put(value, 1);
            }
        }
        // then go through each key as an entry
        for (Map.Entry<Integer, Integer> entry : countedElements.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result[resultIdx] = entry.getKey();
                resultIdx++;
            }
        }
        return result;
    }

}
