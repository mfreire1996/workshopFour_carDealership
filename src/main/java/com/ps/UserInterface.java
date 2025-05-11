package com.ps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public UserInterface() {
        init();
    }

    public void display() {

        System.out.println("Welcome to the dealership program");

        int mainMenuCommand;

        do {
            System.out.println("1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage");
            System.out.println("6. Get by type");
            System.out.println("7. Get all");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Exit");

            System.out.print("Command: ");
            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found, try again");
            }
        } while (mainMenuCommand != 0);
    }

    private void processGetByPriceRequest() {
        // TODO: Ask the user for a starting price and ending price
        System.out.println("--------Display vehicles by price--------");
        System.out.print("Min: ");
        double min = scanner.nextDouble();

        System.out.print("Max: ");
        double max = scanner.nextDouble();


        // ArrayList<Vehicle> filteredVehicles = dealership.getVehiclesByPrice(min, max);
        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByPrice(min, max);

        // Display vehicles with for loop
        displayVehicles(filteredVehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.println("----See Models----");
        scanner.nextLine();

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByMakeModel(make, model);

        displayVehicles(filteredVehicles);
    }

    private void processGetByYearRequest() {
        System.out.println("----See Years----");
        System.out.print("Enter earliest year: ");
        int min = scanner.nextInt();

        System.out.print("Enter latest year: ");
        int max = scanner.nextInt();

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByYear(min, max);

        // Display vehicles with for loop
        displayVehicles(filteredVehicles);
    }

    private void processGetByColorRequest() {
        System.out.println("----See Colors----");
        scanner.nextLine();

        System.out.print("Enter Color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByColor(color);

        displayVehicles(filteredVehicles);
    }

    private void processGetByMileageRequest() {
        System.out.println("----See Mileage----");
        scanner.nextLine();

        System.out.print("Enter minimum mileage: ");
        int minMileage = scanner.nextInt();

        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByMileage(minMileage, maxMileage);

        displayVehicles(filteredVehicles);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("----See Models----");
    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("---------Printing all vehicles-----------");
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("----Add Vehicle----");
        scanner.nextLine();

        System.out.print("Add Vin: ");
        int vin = scanner.nextInt();

        System.out.print("Add Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Add Make: ");
        String make = scanner.nextLine();

        System.out.print("Add Model: ");
        String model = scanner.nextLine();

        System.out.print("Add Type: ");
        String type = scanner.nextLine();

        System.out.print("Add Color: ");
        String color = scanner.nextLine();

        System.out.print("Add Mileage: ");
        int mileage = scanner.nextInt();

        System.out.print("Add Price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
        dealership.addVehicle(newVehicle);

        System.out.println("Vehicle added successfully!");
    }

    private void processRemoveVehicleRequest() {
        System.out.println("----Remove Vehicle----");
        scanner.nextLine();

        System.out.print("Enter Vin: ");
        int vin = scanner.nextInt();

        boolean removed = dealership.removeVehicleByVin(vin);

        if (removed) {
            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("Vehicle with VIN: " + vin + " not found!");
        }
    }

    public static void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            System.out.print(vehicle);
        }
    }

}
