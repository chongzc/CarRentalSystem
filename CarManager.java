package CarRentalSystem;
import java.util.*;
import java.io.*;

public class CarManager {
    private String carModel;
    private int carSeats;
    private String carPlateno;
    private String carPower;
    private String carEngine;
    private String carCategory;
    private double carRate;
    private String carStatus;

    public String getModel() {
        return carModel;
    }

    public int getSeats() {
        return carSeats;
    }

    public String getPlateno() {
        return carPlateno;
    }

    public String getPower() {
        return carPower;
    }

    public String getEngine() {
        return carEngine;
    }

    public String getCategory() {
        return carCategory;
    }

    public double getRate() {
        return carRate;
    }

    public String getStatus() {
        return carStatus;
    }

    public void setStatus(String status) {
        carStatus = status;
    }

    public CarManager(String model, int seat, String plateno, String power, String engine, String category, double rate) {
        carModel = model;
        carSeats = seat;
        carPlateno = plateno;
        carPower = power;
        carEngine = engine;
        carCategory = category;
        carRate = rate;
    }

    public CarManager(String model, int seat, String plateno, String power, String engine, String category, double rate, String status) {
        carModel = model;
        carSeats = seat;
        carPlateno = plateno;
        carPower = power;
        carEngine = engine;
        carCategory = category;
        carRate = rate;
        carStatus = status;
    }

    public static void addCar(Scanner input, ArrayList<CarManager> cars, File1 carFileManager) {
        System.out.println("Enter Car Details:");
        System.out.print("Model: ");
        String carModel = input.nextLine();
        System.out.print("Seats: ");
        int carSeats = input.nextInt();
        input.nextLine();
        System.out.print("Plateno: ");
        String carPlateno = input.nextLine();
        System.out.print("Power: ");
        String carPower = input.nextLine();
        System.out.print("Engine: ");
        String carEngine = input.nextLine();
        System.out.print("Category: ");
        String carCategory = input.nextLine();
        System.out.print("Rate/Day: ");
        double carRate = input.nextDouble();
        input.nextLine();

        cars.add(new CarManager(carModel, carSeats, carPlateno, carPower, carEngine, carCategory, carRate));
        System.out.println("Car added successfully.");

        carFileManager.setListOfCars(cars);
        try {
            carFileManager.saveToFile();
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public static void removeCar(Scanner input, ArrayList<CarManager> cars, File1 carFileManager) {
        System.out.print("Enter the model of the car to remove: ");
        String modelToRemove = input.nextLine();

        boolean removed = false;

        Iterator<CarManager> iterator = cars.iterator();
        while (iterator.hasNext()) {
            CarManager car = iterator.next();
            if (car.getModel().equalsIgnoreCase(modelToRemove)) {
                iterator.remove();
                System.out.println("Car removed successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Car not found in the list.");
        }

        carFileManager.setListOfCars(cars);
        try {
            carFileManager.saveToFile();
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public static void displayCarDetails(CarManager car) {
        System.out.println("Car Model: " + car.getModel());
        System.out.println("Seats: " + car.getSeats());
        System.out.println("Plateno: " + car.getPlateno());
        System.out.println("Power: " + car.getPower());
        System.out.println("Engine: " + car.getEngine());
        System.out.println("Category: " + car.getCategory());
        System.out.println("Rate/Day: " + car.getRate());
        System.out.println("Status: " + car.getStatus());
        System.out.println();
    }

    public static void updateStatus(Scanner input, ArrayList<CarManager> cars) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-15s || %-15s || %-15s%n", "Car Model", "Car Plate No", "Car Status");
        System.out.println("-----------------------------------------------------------------------");

        for (CarManager car : cars) {
            System.out.printf("%-15s || %-15s || %-15s%n", car.getModel(), car.getPlateno(), car.getStatus());
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.print("Enter the car plate no to change the car status: ");
        String plateNoToUpdate = input.nextLine();

        boolean updated = false;

        for (CarManager car : cars) {
            if (car.getPlateno().equalsIgnoreCase(plateNoToUpdate)) {
                System.out.println("Choose status:");
                System.out.println("1. Available");
                System.out.println("2. Not Available");
                int choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    car.setStatus("Available");
                    System.out.println("Car status set to Available.");
                } else if (choice == 2) {
                    car.setStatus("Not Available");
                    System.out.println("Car status set to Not Available.");
                } else {
                    System.out.println("Invalid choice. Car status not updated.");
                }

                updated = true;
                break;
            }
        }

        if (!updated) {
            System.out.println("Car not found with the specified plate no.");
        }
    }

    public static void searchCar(Scanner input, ArrayList<CarManager> cars) {
        System.out.println("Search for a Car:");
        System.out.print("Enter Car Model (Press Enter to skip): ");
        String searchModel = input.nextLine();
        System.out.print("Enter Number of Seats (Press Enter to skip): ");
        String seatsInput = input.nextLine().trim();

        boolean found = false;

        for (CarManager car : cars) {
            boolean modelMatch = searchModel.isEmpty() || car.getModel().toLowerCase().contains(searchModel.toLowerCase()); boolean seatsMatch = seatsInput.isEmpty() || Integer.toString(car.getSeats()).equals(seatsInput);

            if (modelMatch && seatsMatch) {
                displayCarDetails(car);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching cars found.");
        }
    }

}
