package day_02;

public enum Shape {
    A(0),
    B(0),
    C(0),
    X(1),
    Y(2),
    Z(3),
    ;

    final int value;

    Shape(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
