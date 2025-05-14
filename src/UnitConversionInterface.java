import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Unit Conversion Program!");
        System.out.println("---------------------------------------\n");

        int input;

        do {
            displayTypes();
            System.out.print("Please select the type of conversion (0 for Exiting): ");
            input = scanner.nextInt();
            switch (input) {
                case 1 -> lengthConversion();
                case 2 -> System.out.println("Weight conversion is not implemented yet.");
                case 3 -> System.out.println("Time conversion is not implemented yet.");
                case 4 -> System.out.println("Temperature conversion is not implemented yet.");
                case 5 -> System.out.println("Data Storage conversion is not implemented yet.");
                case 0 -> System.out.println("\nThank you for using the Unit Conversion Program. Bye!");
                default -> System.out.println("Invalid conversion type selected.");
            }
        } while (input != 0);
    }

    public static void lengthConversion() {
        LengthConversion.displayUnits();

        String fromUnit;
        while (true) {
            System.out.print("\nEnter the unit to convert *from*: ");
            fromUnit = scanner.nextLine().trim().toLowerCase();
            if (LengthConversion.isValidUnit(fromUnit)) break;
            System.out.println("Invalid unit. Please choose from the list.");
        }

        double length;
        while (true) {
            System.out.print("Enter the length to convert: ");
            try {
                length = Double.parseDouble(scanner.nextLine());
                if (length < 0) {
                    System.out.println("Length cannot be negative.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }

        String toUnit;
        while (true) {
            System.out.print("Enter the unit to convert *to*: ");
            toUnit = scanner.nextLine().trim().toLowerCase();
            if (LengthConversion.isValidUnit(toUnit)) break;
            System.out.println("Invalid unit. Please choose from the list.");
        }

        System.out.println("\nYou entered: " + length + " " + fromUnit + " → " + toUnit);
        LengthConversion conversion = new LengthConversion(length, fromUnit, toUnit);
        conversion.conversion();

    }

    public static void displayTypes() {
        System.out.println("Conversion Types:");
        System.out.println("1. Length");
        System.out.println("2. Weight");
        System.out.println("3. Time");
        System.out.println("4. Temperature");
        System.out.println("5. Data Storage");
    }
}