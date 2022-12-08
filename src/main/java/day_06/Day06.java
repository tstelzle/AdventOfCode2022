package day_06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class Day06 {

    final String INPUT_PATH = "src/main/resources/day_06_input.txt";

    public static void main(String[] args) {
        firstPuzzle();
        secondPuzzle();
    }

    public static void secondPuzzle() {
        detectPosition(14);
    }

    public static void firstPuzzle() {
        detectPosition(4);
    }

    public static void detectPosition(int size) {
        Day06 day06 = new Day06();
        String input = day06.readInput();

        List<Integer> positions = new ArrayList<>();

        for (int index = size - 1; index < input.length(); index++) {
            int firstValue = index - (size - 1);
            int lastValue = index + 1;
            String subString = input.substring(firstValue, lastValue);
            String subList = subString.chars()
                                      .mapToObj(c -> (char) c)
                                      .distinct()
                                      .collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));


            if (subList.length() == size) {
                positions.add(index + 1);
                break;
            }
        }

        System.out.println(positions.get(0));
    }

    public String readInput() {
        String currentLine = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
            currentLine = reader.readLine();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        assert currentLine != "";
        return currentLine;
    }
}
