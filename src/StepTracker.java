import java.util.ArrayList;

public class StepTracker {
    private ArrayList<int[]> stepData = new ArrayList<>();
    private int stepGoal = 10_000;

    public StepTracker() {
        for (int i = 0; i < 12; ++i) {
            stepData.add(new int[30]);
        }
    }

    public void saveStepsForSpecificDay(int month, int day, int numberOfSteps) {
        stepData.get(month)[day - 1] = numberOfSteps;
        System.out.println("Количество шагов за " + day + " день " + month + " месяца установлено и равно " + numberOfSteps + ".\n");
    }

    public void viewStatisticsForMonth(int month) {
        printStepsPerEachDay(month);
        int totalSteps = findTotalSteps(month);
        int maxSteps = findMaxSteps(month);
        int maxStreak = findMaxStreak(month);
        System.out.println("Общее количество шагов за месяц: " + totalSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        System.out.println("Среднее количество шагов: " + (double) totalSteps / 30);
        Converter converter = new Converter();
        System.out.println("Пройденная дистанция: " + converter.convertStepsToKilometers(totalSteps) + " км.");
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalorie(totalSteps));
        System.out.println("Лучшая серия: " + maxStreak + "\n");
    }

    private void printStepsPerEachDay(int month) {
        for (int i = 1; i <= 30; ++i) {
            if (i < 30) {
                System.out.print(i + " день: " + stepData.get(month)[i - 1] + ", ");
            } else {
                System.out.println(i + " день: " + stepData.get(month)[i - 1]);
            }
        }
    }

    int findTotalSteps(int month) {
        int totalSteps = 0;
        for (int i = 1; i <= 30; ++i) {
            totalSteps += stepData.get(month)[i - 1];
        }
        return totalSteps;
    }

    private int findMaxSteps(int month) {
        int maxSteps = 0;
        for (int i = 1; i <= 30; ++i) {
            if (stepData.get(month)[i - 1] > maxSteps) {
                maxSteps = stepData.get(month)[i - 1];
            }
        }
        return maxSteps;
    }

    private int findMaxStreak(int month) {
        int maxStreak = 0;
        int currentStreak = 0;
        for (int i = 1; i <= 30; ++i) {
            if (stepData.get(month)[i - 1] >= stepGoal) {
                // Можно подробнее, почему тут нужно использовать пост-инкремент?
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }
        return maxStreak;
    }

    public void changeStepGoal(int newGoal) {
        if (newGoal < 0) {
            System.out.println("Целевое количество шагов не может быть отрицательным.\n");
        } else {
            stepGoal = newGoal;
        }
    }
}
