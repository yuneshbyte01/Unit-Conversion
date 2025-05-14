import java.util.List;

public class WeightConversion {

    private final double weight;
    private final String fromUnit;
    private final String toUnit;

    private static final List<String> validUnits = List.of(
            "milligram", "centigram", "decigram", "gram", "decagram", "hectogram", "kilogram",
            "ton", "pound", "ounce"
    );

    public WeightConversion(double weight, String fromUnit, String toUnit) {
        this.weight = weight;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
    }

    public static void displayUnits() {
        System.out.println("\nAvailable weight units:");
        for (String unit : validUnits) {
            System.out.println(" - " + unit);
        }
    }

    public static boolean isValidUnit(String unit) {
        return validUnits.contains(unit.toLowerCase());
    }

    public double convert() {
        double valueInGrams = switch (fromUnit) {
            case "milligram" -> weight * 0.001;
            case "centigram" -> weight * 0.01;
            case "decigram" -> weight * 0.1;
            case "gram" -> weight;
            case "decagram" -> weight * 10;
            case "hectogram" -> weight * 100;
            case "kilogram" -> weight * 1000;
            case "ton" -> weight * 1000000;
            case "pound" -> weight * 453.59237;
            case "ounce" -> weight * 28.349523125;
            default -> 0;
        };
        return switch (toUnit) {
            case "milligram" -> valueInGrams / 0.001;
            case "centigram" -> valueInGrams / 0.01;
            case "decigram" -> valueInGrams / 0.1;
            case "gram" -> valueInGrams;
            case "decagram" -> valueInGrams / 10.0;
            case "hectogram" -> valueInGrams / 100.0;
            case "kilogram" -> valueInGrams / 1000.0;
            case "ton" -> valueInGrams / 1000000.0;
            case "pound" -> valueInGrams / 453.59237;
            case "ounce" -> valueInGrams / 28.349523125;
            default -> -1; // Invalid unit
        };
    }

    public void displayResult() {
        double convertedValue = convert();
        if (convertedValue != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s\n", weight, fromUnit, convertedValue, toUnit);
        } else {
            System.out.println("Invalid conversion.");
        }
    }

    public void conversion() {
        displayResult();
    }
}
