package day_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day03 {

    final String INPUT_PATH = "src/main/resources/day_03_input.txt";


    public static void main(String[] args) {
        firstPuzzle();
        secondPuzzle();
    }

    public static void secondPuzzle() {
        Day03 day03 = new Day03();
        List<Rucksack> rucksackList = day03.readInput();

        List<List<Rucksack>> rucksackListList = new ArrayList<>();
        int index = 0;
        while (index < rucksackList.size()) {
            List<Rucksack> subRucksackList = rucksackList.subList(index, index + 3);
            rucksackListList.add(subRucksackList);
            index += 3;
        }

        int badgesValue = rucksackListList.stream()
                                          .mapToInt(Day03::getValueOfRucksackList)
                                          .sum();

        System.out.println(badgesValue);
    }

    public static void firstPuzzle() {
        Day03 day03 = new Day03();
        List<Rucksack> rucksackList = day03.readInput();

        int rucksacksValue = rucksackList.stream()
                                         .mapToInt(Rucksack::pointsForEqualChar)
                                         .sum();

        System.out.println(rucksacksValue);
    }

    public static int getValueOfRucksackList(List<Rucksack> rucksackList) {
        List<List<Character>> charListList = rucksackList.stream()
                                                         .map(rucksack -> {
                                                             rucksack.compartment1.addAll(rucksack.compartment2);
                                                             return rucksack.compartment1;
                                                         })
                                                         .distinct()
                                                         .toList();

        List<Character> charList = charListList.get(0)
                                               .stream()
                                               .filter(c -> charListList.get(1)
                                                                        .contains(c))
                                               .filter(c -> charListList.get(2)
                                                                        .contains(c))
                                               .toList();

        assert charList.size() == 1;

        return getValueOfChar(charList.get(0));
    }

    public static int getValueOfChar(char c) {
        if (Character.isLowerCase(c)) {
            return c - 'a' + 1;
        } else {
            return c - 'A' + 27;
        }
    }

    public List<Rucksack> readInput() {
        List<Rucksack> rucksackList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                rucksackList.add(new Rucksack(currentLine));
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        return rucksackList;
    }
}
