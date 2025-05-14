import java.util.Scanner;

public class UnitConversionInterface {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Unit Conversion Program!");
        System.out.println("---------------------------------------\n");

        int input;

        do {
            displayTypes();
            System.out.print("Please select the type of conversion (0 for Exiting): ");
            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1 -> lengthConverter();
                case 2 -> weightConverter();
                case 3 -> timeConverter();
                case 4 -> temperatureConverter();
                case 5 -> dataStorageConverter();
                case 0 -> System.out.println("\nThank you for using the Unit Conversion Program. Bye!");
                default -> System.out.println("Invalid conversion type selected.");
            }
        } while (input != 0);
    }

    public static void displayTypes() {
        System.out.println("Conversion Types:");
        System.out.println("1. Length");
        System.out.println("2. Weight");
        System.out.println("3. Time");
        System.out.println("4. Temperature");
        System.out.println("5. Data Storage");
    }

    public static void lengthConverter() {

        System.out.println("\n----- Length Conversion -----");

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
        LengthConversion lengthConversion = new LengthConversion(length, fromUnit, toUnit);
        lengthConversion.conversion();

    }

    public static void weightConverter() {

        System.out.println("\n----- Weight Conversion -----");

        WeightConversion.displayUnits();

        String fromUnit;
        while (true) {
            System.out.print("\nEnter the unit to convert *from*: ");
            fromUnit = scanner.nextLine().trim().toLowerCase();
            if (WeightConversion.isValidUnit(fromUnit)) break;
            System.out.println("Invalid unit. Please choose from the list.");
        }

        double weight;
        while (true) {
            System.out.print("Enter the weight to convert: ");
            try {
                weight = Double.parseDouble(scanner.nextLine());
                if (weight < 0) {
                    System.out.println("Weight cannot be negative.");
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
            if (WeightConversion.isValidUnit(toUnit)) break;
            System.out.println("Invalid unit. Please choose from the list.");
        }

        System.out.println("\nYou entered: " + weight + " " + fromUnit + " → " + toUnit);
        WeightConversion weightConversion = new WeightConversion(weight, fromUnit, toUnit);
        weightConversion.conversion();

    }

    public static void timeConverter() {
        System.out.println("\n----- Time Conversion -----");

        TimeConversion.displayUnits();

        String fromUnit;
        while (true) {
            System.out.print("\nEnter the unit to convert *from*: ");
            fromUnit = scanner.nextLine().trim().toLowerCase();
            if (TimeConversion.isValidUnit(fromUnit)) break;
            System.out.println("Invalid unit. Please choose from the list.");
        }

        double time;
        while (true) {
            System.out.print("Enter the time to convert: ");
            try {
                time = Double.parseDouble(scanner.nextLine());
                if (time < 0) {
                    System.out.println("Time cannot be negative.");
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
            if (TimeConversion.isValidUnit(toUnit)) break;
            System.out.println("Invalid unit. Please choose from the list.");
        }

        System.out.println("\nYou entered: " + time + " " + fromUnit + " → " + toUnit);
        TimeConversion timeConversion = new TimeConversion(time, fromUnit, toUnit);
        timeConversion.conversion();

    }

    public static void temperatureConverter() {
        System.out.println("\n----- Temperature Conversion -----");

        TemperatureConversion.displayUnits();

        String fromUnit;
        while (true) {
            System.out.print("\nEnter the unit to convert *from*: ");
            fromUnit = scanner.nextLine().trim().toLowerCase();
            if (TemperatureConversion.isValidUnit(fromUnit)) break;
            System.out.println("Invalid unit. Please choose from the list.");
        }

        double temperature;
        while (true) {
            System.out.print("Enter the temperature to convert: ");
            try {
                temperature = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }

        String toUnit;
        while (true) {
            System.out.print("Enter the unit to convert *to*: ");
            toUnit = scanner.nextLine().trim().toLowerCase();
            if (TemperatureConversion.isValidUnit(toUnit)) break;
            System.out.println("Invalid unit. Please choose from the list.");
        }

        System.out.println("\nYou entered: " + temperature + " " + fromUnit + " → " + toUnit);
        TemperatureConversion temperatureConversion = new TemperatureConversion(temperature, fromUnit, toUnit);
        temperatureConversion.conversion();

    }

    public static void dataStorageConverter() {
        System.out.println("\n----- Data Storage Conversion -----");

        DataStorageConverter.displayUnits();

        String fromUnit;
        while (true) {
            System.out.print("\nEnter the unit to convert *from*: ");
            fromUnit = scanner.nextLine().trim().toLowerCase();
            if (DataStorageConverter.isValidUnit(fromUnit)) break;
            System.out.println("Invalid unit. Please choose from the list.");
        }

        double data;
        while (true) {
            System.out.print("Enter the data to convert: ");
            try {
                data = Double.parseDouble(scanner.nextLine());
                if (data < 0) {
                    System.out.println("Data cannot be negative.");
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
            if (DataStorageConverter.isValidUnit(toUnit)) break;
            System.out.println("Invalid unit. Please choose from the list.");
        }

        System.out.println("\nYou entered: " + data + " " + fromUnit + " → " + toUnit);
        DataStorageConverter dataStorageConverter = new DataStorageConverter(data, fromUnit, toUnit);
        dataStorageConverter.conversion();

    }
}