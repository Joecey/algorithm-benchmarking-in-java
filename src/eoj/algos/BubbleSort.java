package eoj.algos;

public class BubbleSort implements ISorterForIntegers {
    @Override
    public int[] sortIntegerArray(int[] array) {
        return this.bubbleSortBegin(array);
    }

    /*
     * Start with index 0 and 1, if 0 > 1 - swap
     * Continue until 0 < 1 - no swap
     * Then, start again
     * Once you go through the entire array with no swap, the array is sorted
     * larger values "bubble up" to the end
     * time complexity - O(n^2) worse case scenario
     * */
    private int[] bubbleSortBegin(int[] inputArray) {
        boolean arraySorted = false;

        do {
            boolean swappedOccured = false;
            for (int idx = 0; idx < inputArray.length - 1; idx++) {
                // compare value at idx with value at idx+1
                boolean check = inputArray[idx] > inputArray[idx + 1];

                if (check) {
                    // if it is greater, swap their positions
                    int temp = inputArray[idx];
                    inputArray[idx] = inputArray[idx + 1];
                    inputArray[idx + 1] = temp;
                    swappedOccured = true;
                }
            }
            if (!swappedOccured) arraySorted = true;
        } while (!arraySorted);

        return inputArray;
    }
}
