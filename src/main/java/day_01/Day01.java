package day_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

public class Day01 {

    final String INPUT_PATH = "src/main/resources/day_01_input.txt";

    public static void main(String[] args) {
        firstPuzzle();
        secondPuzzle();
    }

    public static void secondPuzzle() {
        Day01 day01 = new Day01();
        List<Elf> elfList = day01.readInput();

        Integer firstThreeElves = elfList.stream()
                                         .mapToInt(Elf::getCalorieSum)
                                         .boxed()
                                         .sorted(Comparator.reverseOrder())
                                         .limit(3)
                                         .reduce(0, Integer::sum);

        System.out.println(firstThreeElves);
    }

    public static void firstPuzzle() {
        Day01 day01 = new Day01();
        List<Elf> elfList = day01.readInput();

        OptionalInt maximum = elfList.stream()
                                     .mapToInt(Elf::getCalorieSum)
                                     .max();

        if (maximum.isPresent()) {
            System.out.println(maximum.getAsInt());
        }
    }

    public List<Elf> readInput() {
        List<Elf> elfList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
            Elf currentElf = new Elf();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                if (!"".equals(currentLine)) {
                    currentElf.addToCalories(Integer.parseInt(currentLine));
                } else {
                    elfList.add(currentElf);
                    currentElf = new Elf();
                }
                currentLine = reader.readLine();
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        return elfList;
    }
}
