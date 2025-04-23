package eoj.algos;

import java.util.Arrays;

public class MergeSort implements ISorterForIntegers {
    @Override
    public int[] sortIntegerArray(int[] array) {
        return startMergeSort(array);
    }

    /*
     * This is an example of a RECURSIVE COMPARISON SORT
     * divide step - keep diving the array in half until you have the base values
     * e.g. [3, 2, 5,4] -> [3,2]; [5,4] -> [3], [2], [5], [4]
     * this is done recursively until the array is of size 0 or 1
     * Conquer step, merge the arrays up using two pointers until back to normal
     * [3]; [2] -> i at 3, j at 2
     * j < i here, so j goes first - then j++
     * j is equal to array size, so add i -> [2,3] (similar, we get [4,5]
     * [2,3] ; [4,5] -> i at 2, j at 4
     * i < j -> set 2, i++ ; i < j -> set 3, i++
     * i >= array length, set 4, j++ - then set 5
     * [2,3,4,5]
     *
     * for code implementation, deal with first half - then second half - then merge
     */

    // follow the steps listed here
    // note that startMergeSort will ONLY ever return a base value or a sorted Array
    private int[] startMergeSort(int[] array) {
        // if we have the base values i.e. arr = 1, then return array
        // 5. return [3]
        // 7. return [2]
        // 13. return [5]
        // 15. return [4]
        if (array.length <= 1) {
            return array;
        }

        // first determine our midpoint, left array, then right array
        int mid = array.length / 2;

        // 1. [3, 2, 5, 4] - split
        // 3. [3, 2] - split
        // 11. [5,4] - split
        // note, copy of range is exclusive of the end point
        int[] leftArray = Arrays.copyOfRange(array, 0, mid);
        int[] rightArray = Arrays.copyOfRange(array, mid, array.length - 1);

        // as we are building back up, we have to merge up the base/sub arrays
        // 2. [3,2]
        // 4. [3]
        // 9. return [2,3]
        // 12. [5]
        int[] sortedLeft = startMergeSort(leftArray);

        // 6. [2]
        // 10. [5,4]
        // 14. [4]
        // 17. return [4,5]
        int[] sortedRight = startMergeSort(rightArray);

        // 8. mergeBack([3], [2])
        // 16. mergeBack([5], [4])
        // 18. mergeBack ([2,3], [4,5])
        return mergeBack(sortedLeft, sortedRight);

        // 19. return [2,3,4,5]
    }

    private int[] mergeBack(int[] left, int[] right) {
        int resultIdx = 0;
        int[] result = new int[left.length + right.length];

        // markers for iterating through our left and right arrays
        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j])  {
                result[resultIdx] = left[i];
                i += 1;
            } else {
                result[resultIdx] = right[j];
                j += 1;
            }
            resultIdx++;
        }
        return result;
    }

}
