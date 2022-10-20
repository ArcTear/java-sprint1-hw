public class Converter {
    double ConvertStepsToKilometers(int steps) {
        return 0.75 * steps / 1000;
    }

    double ConvertStepsToKilocalorie(int steps) {
        return (double) steps * 50 / 1000;
    }
}
