package eoj.algos;

public class SelectionSort implements ISorterForIntegers {
    @Override
    public int[] sortIntegerArray(int[] array) {
        return beginSelectionSort(array);
    }

    /*
     * for each index of our "sorted" array, we are going to go through
     * the unsorted section - replacing the current index we are adding with the smallest number
     * we find
     * e.g. starting at i = 0, with sorted = []
     * 64, 25, 12, 22, 11 - here, we find that 11 is the smallest so
     * sorted[0] = 11 -> 11,... copy the remaining values -> , 25,12, 22, 64 (swap positions)
     * sorted[1] = 12 -> 11, 12,... copy the remaining values  25, 22, 64
     * etc. etc until i reaches the length of our allocated sorted array
     */
    private int[] beginSelectionSort(int[] array) {
       int n = array.length;
        // only up to second last value because at this point, last value should be max
       for (int i = 0; i < n-1; i++){
           // create our new minValueForNewIndex
           int indexForMinValue = i;

           for (int j = i + 1; j < n; j++){
               if (array[j] < array[indexForMinValue]){
                   indexForMinValue = j;
               }
           }

           // then after finding the correct value for the i'th spot - we do a fat swap
           int temp = array[indexForMinValue];
           array[indexForMinValue] = array[i];
           array[i] = temp;
       }


       return array;
    }

}
