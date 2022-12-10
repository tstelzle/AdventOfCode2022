package day_10;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {

    final String EXAMPLE_INPUT_PATH = "src/test/resources/day_10_input.txt";

    @Test
    void testSecondPuzzle() throws IOException {
        List<String> expectedResult = List.of("##..##..##..##..##..##..##..##..##..##..", "###...###...###...###...###...###...###.", "####....####....####....####....####....", "#####.....#####.....#####.....#####.....", "######......######......######......####", "#######.......#######.......#######.....");

        List<String> result = Day10.secondPuzzle(EXAMPLE_INPUT_PATH);

        assertThat(expectedResult).hasSameElementsAs(result);
    }

    @Test
    void testFirstPuzzle() throws IOException {
        assertEquals(13140, Day10.firstPuzzle(EXAMPLE_INPUT_PATH));
    }
}