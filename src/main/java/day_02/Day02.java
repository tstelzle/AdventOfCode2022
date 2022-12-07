package day_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day02 {

    final String INPUT_PATH = "src/main/resources/day_02_input.txt";


    public static void main(String[] args) {
        firstPuzzle();
        secondPuzzle();
    }

    public static void secondPuzzle() {
        Day02 day02 = new Day02();
        List<Game> gameList = day02.readInput(false);

        int gameSum = gameList.stream().mapToInt(Game::calculatePointsBasedOnResult).sum();

        System.out.println(gameSum);
    }

    public static void firstPuzzle() {
        Day02 day02 = new Day02();
        List<Game> gameList = day02.readInput(true);

        int gameSum = gameList.stream().mapToInt(Game::calculatePoints).sum();

        System.out.println(gameSum);
    }

    public List<Game> readInput(boolean firstPuzzle) {
        List<Game> gameList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
            String currentLine = bufferedReader.readLine();
            while(currentLine != null) {
                String[] inputs = currentLine.split(" ");
                Game game;
                if (firstPuzzle) {
                    game = new Game(inputs[0], inputs[1], true);
                }
                else {
                    game = new Game(inputs[0], inputs[1], false);
                }
                gameList.add(game);
                currentLine = bufferedReader.readLine();
            }
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        return gameList;
    }
}
