package day_10;

public class Instruction {

    InstructionEnum instruction;

    int value;

    public Instruction(String input) {
        String[] inputSplit = input.split(" ");

        if ("noop".equals(inputSplit[0])) {
            instruction = InstructionEnum.NOOP;

        } else if ("addx".equals(inputSplit[0])) {
            instruction = InstructionEnum.ADDX;
            value = Integer.parseInt(inputSplit[1]);

        } else {
            System.err.printf("Instruction not known: %s", input);
            System.exit(-1);
        }
    }
}

