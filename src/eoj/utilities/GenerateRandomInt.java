package eoj.utilities;

public class GenerateRandomInt {
    public static int[] randomArray(int arraySize) {
        // for the randomizer, we will just make the range of numbers be from 1 to the size of the array * 5
        int[] newRandomIntArray = new int[arraySize];

        for (int idx = 0; idx < arraySize; idx++) {
            int random = (int) (Math.random() * (arraySize * 5));
            newRandomIntArray[idx] = random;
        }
        return newRandomIntArray;
    }
}
