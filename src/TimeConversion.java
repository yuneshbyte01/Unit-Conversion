import java.util.List;

public class TimeConversion {

    private final double time;
    private final String fromUnit;
    private final String toUnit;

    private static final List<String> validUnits = List.of(
            "millisecond", "microsecond", "nanosecond", "picosecond", "second", "minute", "hour", "day", "week", "month", "year"
    );

    public TimeConversion(double time, String fromUnit, String toUnit) {
        this.time = time;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
    }

    public static void displayUnits() {
        System.out.println("\nAvailable time units:");
        for (String unit : validUnits) {
            System.out.println(" - " + unit);
        }
    }

    public static boolean isValidUnit(String unit) {
        return validUnits.contains(unit.toLowerCase());
    }

    public double convert() {
        double valueInMinutes = switch (fromUnit) {
            case "millisecond" -> time / 60000.0;
            case "microsecond" -> time / 60000000.0;
            case "nanosecond" -> time / 60000000000.0;
            case "picosecond" -> time / 60000000000000.0;
            case "second" -> time / 60.0;
            case "minute" -> time;
            case "hour" -> time * 60.0;
            case "day" -> time * 1440.0;
            case "week" -> time * 10080.0;
            case "month" -> time * 43200.0;
            case "year" -> time * 525600.0;
            default -> -1;
        };
        return switch (toUnit) {
            case "millisecond" -> valueInMinutes * 60000.0;
            case "microsecond" -> valueInMinutes * 60000000.0;
            case "nanosecond" -> valueInMinutes * 60000000000.0;
            case "picosecond" -> valueInMinutes * 60000000000000.0;
            case "second" -> valueInMinutes * 60.0;
            case "minute" -> valueInMinutes;
            case "hour" -> valueInMinutes / 60.0;
            case "day" -> valueInMinutes / 1440.0;
            case "week" -> valueInMinutes / 10080.0;
            case "month" -> valueInMinutes / 43200.0;
            case "year" -> valueInMinutes / 525600.0;
            default -> -1;
        };
    }

    public void displayResult() {
        double result = convert();
        if (result != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s\n", time, fromUnit, result, toUnit);
        } else {
            System.out.println("Invalid conversion.");
        }
    }

    public void conversion() {
        displayResult();
    }
}
