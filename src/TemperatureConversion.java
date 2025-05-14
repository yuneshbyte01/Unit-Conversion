import java.util.List;

public class TemperatureConversion {
    private final double temperature;
    private final String fromUnit;
    private final String toUnit;

    private static final List<String> validUnits = List.of(
            "celsius", "fahrenheit", "kelvin"
    );

    public TemperatureConversion(double temperature, String fromUnit, String toUnit) {
        this.temperature = temperature;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
    }

    public static void displayUnits() {
        System.out.println("\nAvailable temperature units:");
        for (String unit : validUnits) {
            System.out.println(" - " + unit);
        }
    }

    public static boolean isValidUnit(String unit) {
        return validUnits.contains(unit.toLowerCase());
    }

    public double convert() {
        double valueInCelsius = switch (fromUnit) {
            case "celsius" -> temperature;
            case "fahrenheit" -> (temperature - 32) * 5 / 9;
            case "kelvin" -> temperature - 273.15;
            default -> -1;
        };
        return switch (toUnit) {
            case "celsius" -> valueInCelsius;
            case "fahrenheit" -> (valueInCelsius * 9 / 5) + 32;
            case "kelvin" -> valueInCelsius + 273.15;
            default -> -1;
        };
    }

    public void displayResult() {
        double result = convert();
        if (result != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s\n", temperature, fromUnit, result, toUnit);
        } else {
            System.out.println("Invalid conversion.");
        }
    }

    public void conversion() {
        displayResult();
    }
}
