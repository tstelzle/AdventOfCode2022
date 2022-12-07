package day_03;

import org.junit.jupiter.api.Test;

class Day03Test {

    @Test
    void testGetValueOfCharWithc() {
        assert Day03.getValueOfChar('c') == 3;
    }

    @Test
    void testGetValueOfCharWitha() {
        assert Day03.getValueOfChar('a') == 1;
    }

    @Test
    void testGetValueOfCharWithA() {
        assert Day03.getValueOfChar('A') == 27;
    }

    @Test
    void testGetValueOfCharWithC() {
        assert Day03.getValueOfChar('C') == 29;
    }
}