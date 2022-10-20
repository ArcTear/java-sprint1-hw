import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int command;
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        do {
            System.out.println("""
                    Введите номер команды:
                    1.Ввести количество шагов за определённый день
                    2.Напечатать статистику за определённый месяц
                    3.Изменить цель по количеству шагов в день
                    4.Выйти из приложения.""");
            command = scanner.nextInt();
            if (command < 1 || command > 4) {
                System.out.println("Неверный номер команды, повторите ввод.\n");
            } else if (command == 1) {
                System.out.println("Введите номер месяца: ");
                int month = scanner.nextInt();
                // Обрабатываю некорректные данные здесь, т.к. если введено некорректное значение одного из параметров,
                // то ввод остальных не имеет смысла.
                if (month < 0 || month > 11) {
                    System.out.println("Неверный номер месяца.\n");
                    continue;
                }
                System.out.println("Введите номер дня: ");
                int day = scanner.nextInt();
                if (day < 1 || day > 30) {
                    System.out.println("Неверный номер дня.\n");
                    continue;
                }
                System.out.println("Введите количество шагов: ");
                int numberOfSteps = scanner.nextInt();
                if (numberOfSteps < 0) {
                    System.out.println("Неверное количество шагов.\n");
                    continue;
                }
                stepTracker.SaveStepsForSpecificDay(month, day, numberOfSteps);
            } else if (command == 2) {
                System.out.println("Введите номер месяца: ");
                int month = scanner.nextInt();
                if (month < 0 || month > 11) {
                    System.out.println("Неверный номер месяца.\n");
                    continue;
                }
                stepTracker.ViewStatisticsForMonth(month);
            } else if (command == 3) {
                System.out.println("Введите целевое количество шагов: ");
                stepTracker.ChangeStepGoal(scanner.nextInt());
            } else {
                System.out.println("Выход из приложения.");
            }
        } while (command != 4);
    }
}
