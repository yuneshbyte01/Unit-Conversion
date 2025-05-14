import java.util.List;

public class LengthConversion {

    private final double length;
    private final String fromUnit;
    private final String toUnit;

    private static final List<String> validUnits = List.of(
            "millimeter", "centimeter", "decimeter", "meter", "decameter", "hectometer", "kilometer",
            "inch", "feet", "yard", "mile"
    );

    public LengthConversion(double length, String fromUnit, String toUnit) {
        this.length = length;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
    }

    public static void displayUnits() {
        System.out.println("\nAvailable length units:");
        for (String unit : validUnits) {
            System.out.println(" - " + unit);
        }
    }

    public static boolean isValidUnit(String unit) {
        return validUnits.contains(unit.toLowerCase());
    }

    public double convert() {
        double valueInMeters = switch (fromUnit) {
            case "millimeter" -> length * 0.001;
            case "centimeter" -> length * 0.01;
            case "decimeter" -> length * 0.1;
            case "meter" -> length;
            case "decameter" -> length * 10;
            case "hectometer" -> length * 100;
            case "kilometer" -> length * 1000;
            case "inch" -> length * 0.0254;
            case "yard" -> length * 0.9144;
            case "mile" -> length * 1609.34;
            case "feet" -> length * 0.3048;
            default -> 0;
        };
        return switch (toUnit) {
            case "millimeter" -> valueInMeters / 0.001;
            case "centimeter" -> valueInMeters / 0.01;
            case "decimeter" -> valueInMeters / 0.1;
            case "meter" -> valueInMeters;
            case "decameter" -> valueInMeters / 10.0;
            case "hectometer" -> valueInMeters / 100.0;
            case "kilometer" -> valueInMeters / 1000.0;
            case "inch" -> valueInMeters / 0.0254;
            case "yard" -> valueInMeters / 0.9144;
            case "mile" -> valueInMeters / 1609.34;
            case "feet" -> valueInMeters / 0.3048;
            default -> -1;
        };
    }

    public void displayResult() {
        double result = convert();
        if (result != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s\n", length, fromUnit, result, toUnit);
        } else {
            System.out.println("Invalid conversion.");
        }
    }

    public void conversion() {
        displayResult();
    }

}