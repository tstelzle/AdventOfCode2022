package day_04;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Elf {

    public int firstNumber;
    public int secondNumber;
    public List<Integer> campList;

    public Elf(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;

        campList = IntStream.range(firstNumber, secondNumber + 1)
                            .boxed()
                            .collect(Collectors.toList());
    }
}
