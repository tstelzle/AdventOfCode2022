package day_02;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Game {

    public final Map<List<Shape>, Outcome> rockPaperScissorMapping = Map.ofEntries(
            Map.entry(List.of(Shape.A, Shape.X), Outcome.DRAW),
            Map.entry(List.of(Shape.A, Shape.Y), Outcome.WIN),
            Map.entry(List.of(Shape.A, Shape.Z), Outcome.LOSS),

            Map.entry(List.of(Shape.B, Shape.X), Outcome.LOSS),
            Map.entry(List.of(Shape.B, Shape.Y), Outcome.DRAW),
            Map.entry(List.of(Shape.B, Shape.Z), Outcome.WIN),

            Map.entry(List.of(Shape.C, Shape.X), Outcome.WIN),
            Map.entry(List.of(Shape.C, Shape.Y), Outcome.LOSS),
            Map.entry(List.of(Shape.C, Shape.Z), Outcome.DRAW)
    );

    final Shape opponentChoice;
    Shape yourChoice;
    Outcome outcome;

    public Game(String value1, String value2, boolean parseAsYourChoice) {
        this.opponentChoice = Shape.valueOf(value1);
        if (parseAsYourChoice) {
            this.yourChoice = Shape.valueOf(value2);
        } else {
            switch (value2) {
                case "X" -> this.outcome = Outcome.LOSS;
                case "Y" -> this.outcome = Outcome.DRAW;
                case "Z" -> this.outcome = Outcome.WIN;
            }
        }
    }


    public int calculatePoints() {
        assert this.yourChoice != null;
        return rockPaperScissorMapping.get(List.of(this.opponentChoice, this.yourChoice))
                                      .getValue() + this.yourChoice.getValue();
    }

    public int calculatePointsBasedOnResult() {
        assert this.outcome != null;
        return getYourChoice().getValue() + this.outcome.getValue();
    }

    public Shape getYourChoice() {
        return Stream.of(Shape.X, Shape.Y, Shape.Z)
                     .filter(value -> rockPaperScissorMapping.get(List.of(this.opponentChoice, value))
                                                             .getValue() == this.outcome.getValue())
                     .toList()
                     .get(0);
    }
}
