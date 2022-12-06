package day_01;

import java.util.ArrayList;
import java.util.List;

public class Elf {

    List<Integer> caloriesList = new ArrayList<>();

    public void addToCalories(Integer calorie) {
        this.caloriesList.add(calorie);
    }

    public int getCalorieSum() {
        return caloriesList.stream()
                           .reduce(0, Integer::sum);
    }

}
