package eoj.utilities;

public class PrintTableRow {

    /**
     * Used to consistently print a "table" row with a title column and 13 data columns
     *
     * @param leftMostColumn Title of the left most column of row
     * @param dataArray      array of strings to display columns of data
     */
    public static <String> void displayRow(String leftMostColumn, String[] dataArray) {

        System.out.format("%-12s",leftMostColumn);
        for (String dataPoint: dataArray) System.out.printf("%-14s", dataPoint);
        System.out.println();

    }
}
