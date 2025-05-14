import java.util.List;

public class DataStorageConverter {

    private final double data;
    private final String fromUnit;
    private final String toUnit;

    private static final List<String> validUnits= List.of(
            "bit", "byte", "kilobyte", "megabyte", "gigabyte", "terabyte", "petabyte"
    );

    public DataStorageConverter(double data, String fromUnit, String toUnit) {
        this.data = data;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
    }

    public static void displayUnits() {
        System.out.println("\nAvailable data storage units:");
        for (String unit : validUnits) {
            System.out.println(" - " + unit);
        }
    }

    public static boolean isValidUnit(String unit) {
        return validUnits.contains(unit.toLowerCase());
    }

    public double convert() {
        double valueInBytes = switch (fromUnit) {
            case "bit" -> data / 8;
            case "byte" -> data;
            case "kilobyte" -> data * 1024;
            case "megabyte" -> data * Math.pow(1024,2);
            case "gigabyte" -> data * Math.pow(1024,3);
            case "terabyte" -> data * Math.pow(1024,4);
            case "petabyte" -> data * Math.pow(1024,5);
            default -> -1;
        };
        return switch (toUnit) {
            case "bit" -> valueInBytes * 8;
            case "byte" -> valueInBytes;
            case "kilobyte" -> valueInBytes / 1024;
            case "megabyte" -> valueInBytes / Math.pow(1024,2);
            case "gigabyte" -> valueInBytes / Math.pow(1024,3);
            case "terabyte" -> valueInBytes / Math.pow(1024,4);
            case "petabyte" -> valueInBytes / Math.pow(1024,5);
            default -> -1;
        };
    }

    public void displayResult() {
        double result = convert();
        if (result != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s\n", data, fromUnit, result, toUnit);
        } else {
            System.out.println("Invalid conversion.");
        }
    }

    public void conversion() {
        displayResult();
    }
}
