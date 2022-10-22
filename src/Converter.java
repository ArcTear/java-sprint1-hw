public class Converter {
    final double stepLength = 0.75;
    final int caloriesPerStep = 50;
    final int turnToKilo = 1000;

    double convertStepsToKilometers(int steps) {
        return stepLength * steps / turnToKilo;
    }

    double convertStepsToKilocalorie(int steps) {
        return (double) steps * caloriesPerStep / turnToKilo;
    }
}
