public class PrintTableRow {

    /**
     * Used to consistently print a "table" row with a title column and 13 data columns
     *
     * @param leftMostColumn Title of the left most column of row
     * @param column1        (2,3,4,5 etc...) String to display in column x (up to column13)
     */
    public static void displayRow(String leftMostColumn, String column1, String column2,
                                  String column3, String column4, String column5, String column6,
                                  String column7, String column8, String column9, String column10,
                                  String column11, String column12, String column13) {

        System.out.format("%s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s",
                leftMostColumn, column1, column2, column3, column4, column5, column6,
                column7, column8, column9, column10, column11, column12, column13);
    }
}
