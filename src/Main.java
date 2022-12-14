import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int command;
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        do {
            printMenu();
            command = scanner.nextInt();
            if (command == 1) {
                setStepsForSpecificDay(stepTracker, scanner);
            } else if (command == 2) {
                printStatisticsForSpecificMonth(stepTracker, scanner);
            } else if (command == 3) {
                setStepGoal(stepTracker, scanner);
            } else if (command == 4) {
                System.out.println("Выход из приложения.");
            } else {
                System.out.println("Неверный номер команды, повторите ввод.\n");
            }
        } while (command != 4);
    }

    public static void printMenu() {
        System.out.println("Введите номер команды:\n1.Ввести количество шагов за определённый день\n2.Напечатать статистику за определённый месяц\n3.Изменить цель по количеству шагов в день\n4.Выйти из приложения.");
    }

    public static void setStepsForSpecificDay(StepTracker stepTracker, Scanner scanner) {
        System.out.println("Введите номер месяца: ");
        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Неверный номер месяца.\n");
            return;
        }
        System.out.println("Введите номер дня: ");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Неверный номер дня.\n");
            return;
        }
        System.out.println("Введите количество шагов: ");
        int numberOfSteps = scanner.nextInt();
        if (numberOfSteps < 0) {
            System.out.println("Неверное количество шагов.\n");
            return;
        }
        stepTracker.saveStepsForSpecificDay(month, day, numberOfSteps);
    }

    public static void printStatisticsForSpecificMonth(StepTracker stepTracker, Scanner scanner) {
        System.out.println("Введите номер месяца: ");
        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Неверный номер месяца.\n");
            return;
        }
        stepTracker.viewStatisticsForMonth(month);
    }

    public static void setStepGoal(StepTracker stepTracker, Scanner scanner) {
        System.out.println("Введите целевое количество шагов: ");
        stepTracker.changeStepGoal(scanner.nextInt());
    }
}
