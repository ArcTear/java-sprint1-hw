import java.util.ArrayList;

public class StepTracker {
    private ArrayList<int[]> stepData = new ArrayList<>();
    private int stepGoal = 10_000;

    public StepTracker() {
        for (int i = 0; i < 12; ++i) {
            stepData.add(new int[30]);
        }
    }

    public void SaveStepsForSpecificDay(int month, int day, int numberOfSteps) {
        stepData.get(month)[day - 1] = numberOfSteps;
        System.out.println("Количество шагов за " + day + " день " + month + " месяца установлено и равно " + numberOfSteps + ".\n");
    }

    public void ViewStatisticsForMonth(int month) {
        int totalSteps = 0;
        int maxSteps = 0;
        // Максимальная "серия" подряд идущих дней, когда выполнена цель
        int maxStreak = 0;
        // Текущая "серия" подряд идущих дней, когда выполнена цель
        int currentStreak = 0;
        for (int i = 1; i <= 30; ++i) {
            totalSteps += stepData.get(month)[i - 1];
            // Поиск максимума
            if (stepData.get(month)[i - 1] > maxSteps) {
                maxSteps = stepData.get(month)[i - 1];
            }
            // Поиск максимальной "серии"
            if (stepData.get(month)[i - 1] >= stepGoal) {
                ++currentStreak;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            }
            if (i < 30) {
                System.out.print(i + " день: " + stepData.get(month)[i - 1] + ", ");
            } else {
                System.out.println(i + " день: " + stepData.get(month)[i - 1]);
            }
        }
        System.out.println("Общее количество шагов за месяц: " + totalSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        System.out.println("Среднее количество шагов: " + (double) totalSteps / 30);
        Converter converter = new Converter();
        System.out.println("Пройденная дистанция: " + converter.ConvertStepsToKilometers(totalSteps) + " км.");
        System.out.println("Количество сожжённых килокалорий: " + converter.ConvertStepsToKilocalorie(totalSteps) + '\n');
    }

    public void ChangeStepGoal(int newGoal) {
        if (newGoal < 0) {
            System.out.println("Целевое количество шагов не может быть отрицательным.\n");
        } else {
            stepGoal = newGoal;
        }
    }
}
