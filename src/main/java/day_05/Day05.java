package day_05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;

public class Day05 {

    final String INPUT_PATH = "src/main/resources/day_05_input.txt";

    public static void main(String[] args) {
        firstPuzzle();
        secondPuzzle();
    }

    public static void secondPuzzle() {
        Day05 day05 = new Day05();
        List<Stack> stackList = day05.readInput(false);

        String output = stackList.stream()
                                 .map(Stack::getTopOfStack)
                                 .collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));

        System.out.println(output);
    }

    public static void firstPuzzle() {
        Day05 day05 = new Day05();
        List<Stack> stackList = day05.readInput(true);

        String output = stackList.stream()
                                 .map(Stack::getTopOfStack)
                                 .collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));

        System.out.println(output);
    }

    public static List<Integer> getNumbersFromString(String line) {
        Pattern integerPattern = Pattern.compile("-?\\d+");
        Matcher matcher = integerPattern.matcher(line);

        List<Integer> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(Integer.parseInt(matcher.group()));
        }

        return integerList;
    }

    public List<Stack> readInput(boolean firstPuzzle) {
        List<Stack> stackList = new ArrayList<>();

        boolean firstHalf = true;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                if ("".equals(currentLine)) {
                    firstHalf = false;
                    currentLine = bufferedReader.readLine();
                    continue;
                }

                if (firstHalf) {
                    int amountStacks = currentLine.length() / 4;

                    if (stackList.size() != amountStacks) {
                        for (int i = stackList.size(); i <= amountStacks; i++) {
                            Stack stack = new Stack();
                            stackList.add(stack);
                        }
                    }
                    for (int i = 0; i < currentLine.length(); i++) {
                        if (Character.isLetter(currentLine.charAt(i))) {
                            stackList.get(i / 4)
                                     .addToStack(currentLine.charAt(i));
                        }
                    }
                } else {
                    List<Integer> integerList = getNumbersFromString(currentLine);

                    if (firstPuzzle) {
                        for (int i = 0; i < integerList.get(0); i++) {
                            Stack stack = stackList.get(integerList.get(1) - 1);
                            char c = stack.removeLastElementFromStack();
                            stackList.get(integerList.get(2) - 1).stack.add(c);
                        }
                    } else {
                        List<Character> charList = new ArrayList<>();
                        for (int i = 0; i < integerList.get(0); i++) {
                            Stack stack = stackList.get(integerList.get(1) - 1);
                            char c = stack.removeLastElementFromStack();
                            charList.add(0, c);
                        }
                        charList.forEach(c -> stackList.get(integerList.get(2) - 1).stack.add(c));
                    }
                }
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        return stackList;
    }
}
