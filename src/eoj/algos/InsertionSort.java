package eoj.algos;

public class InsertionSort implements ISorterForIntegers{
    @Override
    public int[] sortIntegerArray(int[] array) {
        return beginInsertionSort(array);
    }

    /*
    * move elements one at a time into correct position
    * 4,5,1,2,3,7,8
    * move higher values to top as needed - our "sorted" part continues to grow
    * as you move up, move new values to their corresponding spot in the sorted section
    * 4,5,1,2,3,7,8
    * 1,4,5,2,3,7,8
    * 1,2,4,5,3,7,8
    * 1,2,3,4,5,7,8 - DONE!
    * This is also O(n^2) due to the need of two loops
     */
    private int[] beginInsertionSort(int[] array){
        // traditionally, we start with the first index as our "sorted" section
        // so, now we are starting at i = 1
        int startingPoint = 1;

        // while we are not at the end of the array
        while (startingPoint < array.length){
            int movingPoint = startingPoint;
            // get the current value, and move down until it is in the right spot
            // 0 -> indicates it's at the start
            // array[movingPoint -1] > array[movingPoint] - check if number to the left is greater
            while (movingPoint > 0 && array[movingPoint -1] > array[movingPoint]){
                // swap
                int temp = array[movingPoint - 1];
                array[movingPoint - 1] = array[movingPoint];
                array[movingPoint] = temp;

                // then we reduce the value, and check again
                movingPoint -= 1;
            }
            // then, we go to the next number
            // if this new number is an already sorted value that's okay cus it
            // wil just skip the inner while loop
            startingPoint += 1;
        }
        return array;
    }

}
