package day_05;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    public List<Character> stack = new ArrayList<>();

    public Stack() {

    }

    public void addToStack(Character c) {
        stack.add(0, c);
    }

    public Character removeLastElementFromStack() {
        return stack.remove(stack.size() - 1);
    }

    public Character getTopOfStack() {
        return stack.get(stack.size() - 1);
    }
}
