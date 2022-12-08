package day_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day04 {

    final String INPUT_PATH = "src/main/resources/day_04_input.txt";

    public static void main(String[] args) {
        firstPuzzle();
        secondPuzzle();
    }

    public static void secondPuzzle() {
        Day04 day04 = new Day04();
        List<List<Elf>> elfListList = day04.readInput();

        long count = elfListList.stream()
                                .filter(Day04::areListOverlapping)
                                .count();

        System.out.println(count);
    }

    public static void firstPuzzle() {
        Day04 day04 = new Day04();
        List<List<Elf>> elfListList = day04.readInput();

        long count = elfListList.stream()
                                .filter(Day04::isAnyListContainedInTheOther)
                                .count();

        System.out.println(count);
    }

    public static boolean areListOverlapping(List<Elf> elfList) {
        return elfList.get(0).campList.stream()
                                      .anyMatch(v -> elfList.get(1).campList.contains(v)) || elfList.get(1).campList.stream()
                                                                                                                    .anyMatch(v -> elfList.get(0).campList.contains(v));
    }

    public static boolean isAnyListContainedInTheOther(List<Elf> elfList) {
        return elfList.get(0).campList.containsAll(elfList.get(1).campList) || elfList.get(1).campList.containsAll(elfList.get(0).campList);
    }

    public List<List<Elf>> readInput() {
        List<List<Elf>> elfListList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                String[] elfAssignments = currentLine.split(",");
                int elfOneValueOne = Integer.parseInt(elfAssignments[0].split("-")[0]);
                int elfOneValueTwo = Integer.parseInt(elfAssignments[0].split("-")[1]);
                int elfTwoValueOne = Integer.parseInt(elfAssignments[1].split("-")[0]);
                int elfTwoValueTwo = Integer.parseInt(elfAssignments[1].split("-")[1]);

                Elf elfOne = new Elf(elfOneValueOne, elfOneValueTwo);
                Elf elfTwo = new Elf(elfTwoValueOne, elfTwoValueTwo);

                elfListList.add(List.of(elfOne, elfTwo));

                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        return elfListList;
    }
}
