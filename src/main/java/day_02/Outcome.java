package day_02;

public enum Outcome {
    WIN(6),
    DRAW(3),
    LOSS(0);

    private final int value;

    Outcome(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
