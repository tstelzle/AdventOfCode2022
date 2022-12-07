package day_03;

import java.util.List;
import java.util.stream.Collectors;

public class Rucksack {

    List<Character> compartment1;
    List<Character> compartment2;

    public Rucksack(String packing) {
        int packingSize = packing.length();

        compartment1 = packing.substring(0, packingSize / 2)
                              .chars()
                              .mapToObj(c -> (char) c)
                              .collect(Collectors.toList());
        compartment2 = packing.substring(packingSize / 2, packingSize)
                              .chars()
                              .mapToObj(c -> (char) c)
                              .collect(Collectors.toList());

        assert compartment2.size() == compartment1.size();
    }

    public int pointsForEqualChar() {
        List<Character> equalChars = sameCharsInCompartments();
        return equalChars.stream()
                         .mapToInt(Day03::getValueOfChar)
                         .sum();
    }

    public List<Character> sameCharsInCompartments() {
        return compartment1.stream()
                           .filter(c -> compartment2.contains(c))
                           .distinct()
                           .collect(Collectors.toList());
    }
}
