package eoj.utilities;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateResultsCSV {
    static String CSV_FILE_NAME = "./results.csv";


    private GenerateResultsCSV() {
    }


    public static void createResultsCSV(List<String[]> dataLines) throws IOException {
        File csvResultsFile = new File(CSV_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvResultsFile)) {
            dataLines.stream()
                    .map(GenerateResultsCSV::convertToCSV)
                    .forEach(pw::println);
        }
    }

    public static String[] combineKeyAndArray(String key, String[] data) {
        List<String> result = new ArrayList<>();
        result.add(key);
        result.addAll(Arrays.asList(data));
        return result.toArray(new String[0]);
    }

    private static String convertToCSV(String[] data) {
        return String.join(",", data);
    }
}
