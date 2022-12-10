package day_10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Device {

    public int cycle;
    public int value;
    public int nextInputValue;
    public List<Integer> spritePositions = List.of(1, 2, 3);
    public Map<Integer, List<Integer>> spritePositionsHistory = new HashMap<>();
    public Map<Integer, Integer> deviceHistory = new HashMap<>();

    public Device() {
        cycle = 0;
        value = 1;
    }

    public void applyInstruction(Instruction instruction) {
        value += nextInputValue;
        if (instruction.instruction == InstructionEnum.NOOP) {
            cycle += 1;
            nextInputValue = 0;
        } else if (instruction.instruction == InstructionEnum.ADDX) {
            cycle += 1;
            deviceHistory.put(cycle, value);
            cycle += 1;
            nextInputValue = instruction.value;
        }
        deviceHistory.put(cycle, value);
    }

    public void calculateSpritePosition() {
        spritePositionsHistory.put(1, spritePositions);
        for (int deviceHistoryId = 2; deviceHistoryId <= deviceHistory.size(); deviceHistoryId++) {
            if (!Objects.equals(deviceHistory.get(deviceHistoryId - 1), deviceHistory.get(deviceHistoryId))) {
                int difference = deviceHistory.get(deviceHistoryId) - deviceHistory.get(deviceHistoryId - 1);
                spritePositions = spritePositions.stream()
                                                 .mapToInt(spritePosition -> spritePosition + difference)
                                                 .boxed()
                                                 .collect(Collectors.toList());
            }
            spritePositionsHistory.put(deviceHistoryId, spritePositions);
        }
    }
}
