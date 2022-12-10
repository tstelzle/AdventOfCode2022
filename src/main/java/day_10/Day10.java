package day_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day10 {

    final static String INPUT_PATH = "src/main/resources/day_10_input.txt";

    public static void main(String[] args) throws IOException {
        System.out.println(firstPuzzle(Day10.INPUT_PATH));
        printListOfStrings(secondPuzzle(Day10.INPUT_PATH));
    }

    public static void printListOfStrings(List<String> stringList) {
        stringList.forEach(System.out::println);
    }

    public static List<String> secondPuzzle(String input) throws IOException {
        Day10 day10 = new Day10();
        List<Instruction> instructionList = day10.readInput(input);
        Device device = new Device();
        instructionList.forEach(device::applyInstruction);
        device.calculateSpritePosition();

        StringBuilder resultString = new StringBuilder();
        List<String> resultList = new ArrayList<>();

        for (int index = 1; index <= device.spritePositionsHistory.size(); index++) {
            List<Integer> spritePositions = device.spritePositionsHistory.get(index);
            if (spritePositions.contains(index % 40) || index % 40 == 0 && spritePositions.contains(40)) {
                resultString.append("#");
            } else {
                resultString.append(".");
            }
            if (index % 40 == 0) {
                resultList.add(resultString.toString());
                resultString = new StringBuilder();
            }
        }

        return resultList;
    }

    public static int firstPuzzle(String input) throws IOException {
        Day10 day10 = new Day10();
        List<Instruction> instructionList = day10.readInput(input);
        Device device = new Device();
        instructionList.forEach(device::applyInstruction);

        return Stream.of(20, 60, 100, 140, 180, 220)
                     .mapToInt(cycleTime -> cycleTime * device.deviceHistory.get(cycleTime))
                     .sum();
    }

    public List<Instruction> readInput(String input) throws IOException {
        try (Stream<String> inputs = Files.lines(Paths.get(input))) {
            return inputs.map(Instruction::new)
                         .collect(Collectors.toList());
        }
    }

}
