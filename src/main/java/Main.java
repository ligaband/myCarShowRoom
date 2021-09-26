import cars.Car;
import cars.ShowRoom;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    ShowRoom showRoom = new ShowRoom();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }

    void showMenu() {

        String userInput = "";

        do {
            System.out.println("\nWelcome to the showroom, please choose an activity: ");
            System.out.println("1. Add car");
            System.out.println("2. View all cars");
            System.out.println("3. View single car");
            System.out.println("4. Remove car");
            System.out.println("5. Find car by name");
            System.out.println("6. Find car by type");
            System.out.println("7. Find car by manufacturer");
            System.out.println("8. Remove car by name");
            System.out.println("9. Update car by name");
            System.out.println("10. Update car by manufacturer");
            System.out.println("11. Update car by type");
            System.out.println("12. Search by property");
            System.out.println("\nEnter Quit to end program....");

            System.out.println("Choose a number:");
            userInput = scanner.nextLine();
            switch (userInput) {
                case "Quit", "QUIT", "quit":
                    System.out.println("Exit application...");
                    break;
                case "1":
                    addCar();
                    break;
                case "2":
                    viewAllCars();
                    break;
                case "3":
                    viewSingleCar();
                    break;
                case "4":
                    removeCar();
                    break;
                case "5":
                    findByName();
                    break;
                case "6":
                    findByType();
                    break;
                case "7":
                    findByManufacturer();
                    break;
                case "8":
                    removeCarByName();
                    break;
                case "9":
                    updateCarByName();
                    break;
                case "10":
                    updateCarByManufacturer();
                    break;
                case "11":
                    updateCarByType();
                    break;
                case "12":
                    searchByProperty();
                    break;
                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("Quit"));
        return;
    }

    void addCar() {

        System.out.println("Add car");

        Car car = new Car();
        System.out.println("Enter name:");
        car.name = scanner.nextLine();

        System.out.println("Enter manufacturer:");
        car.manufacturer = scanner.nextLine();

        System.out.println("Enter type:");
        car.type = scanner.nextLine();

        car.id = UUID.randomUUID();

        String massage = showRoom.addCar(car);
        System.out.println(massage);

    }

    void viewAllCars() {
        ArrayList<Car> allCars = showRoom.getAllCars();

        System.out.println("\nAll available cars");
        System.out.println("Car name\tManufacturer\tCar type");
        for (Car car : allCars) {
            System.out.println(car.name + "\t\t\t" + car.manufacturer + " \t\t\t" + car.type);
        }
    }

    //create method to view single car
    void viewSingleCar() {
        //Print name of method first to show selected method
        System.out.println("View Car");
        //receive the car id to view from the user
        System.out.println("Please provide a car ID: ");
        int carId = scanner.nextInt();

        //view specified car
//        Car car = showRoom.getSingleCar(carId);
//        System.out.println("Car Number: " + car.id);
//        System.out.println("Car Name: " + car.name);
//        System.out.println("Car Manufacturer: " + car.manufacturer);
//        System.out.println("Car Type: " + car.type);

        //the same viewSingleCar but with String
        String massage = showRoom.getSingleCar(carId);
        System.out.println(massage);

    }

    //remove car
    void removeCar() {

        System.out.println("Please provide a car ID to remove a car: ");

        int removeCar = scanner.nextInt();
        String massage = showRoom.removeCar(removeCar);
        System.out.println(massage);

    }

    void findByName() {
        System.out.println("Find car by name");
        System.out.println("Enter car name");

        String carName = scanner.nextLine();
        Car car = showRoom.findByName(carName);

        System.out.println("car name: " + car.name);
        System.out.println("car manufacturer: " + car.manufacturer);
        System.out.println("car type: " + car.type);
    }

    void findByType() {
        System.out.println("Find car by type");
        System.out.println("Enter car type");

        String carType = scanner.nextLine();
        Car car = showRoom.findByType(carType);

        System.out.println("car name: " + car.name);
        System.out.println("car manufacturer: " + car.manufacturer);
        System.out.println("car type: " + car.type);
    }

    void findByManufacturer() {
        System.out.println("Find car by manufacturer");
        System.out.println("Enter car manufacturer");

        String carManufacturer = scanner.nextLine();
        Car car = showRoom.findByManufacturer(carManufacturer);

        System.out.println("car name: " + car.name);
        System.out.println("car manufacturer: " + car.manufacturer);
        System.out.println("car type: " + car.type);
    }


    void removeCarByName() {
        System.out.println("Remove car by name");
        System.out.println("Enter car name:");

        String carName = scanner.nextLine();
        Car car = showRoom.findByName(carName);

        int carId = showRoom.getAllCars().indexOf(car);
        System.out.println(showRoom.removeCar(carId));

    }

    void updateCarByName() {
        System.out.println("Update car...");
        System.out.println("Enter car name:");
        String carName = scanner.nextLine();

        Car car = showRoom.findByName(carName);

        int carId = showRoom.getAllCars().indexOf(car);
        System.out.println("Enter the property you would like to change:");
        String property = scanner.nextLine();

        System.out.println("Enter the new value of: " + property);
        String value = scanner.nextLine();

        switch (property) {
            case "name":
                car.name = value;
                break;
            case "manufacturer":
                car.manufacturer = value;
                break;
            case "type":
                car.type = value;
                break;
            default:
                System.out.println("Please provide a valid property");
                break;
        }

        showRoom.updateCarByName(carId, car);
        System.out.println(car.name + " updated successfully");


    }

    void updateCarByManufacturer() {
        System.out.println("Update car...");
        System.out.println("Enter car manufacturer:");
        String carManufacturer = scanner.nextLine();

        Car car = showRoom.findByManufacturer(carManufacturer);

        int carId = showRoom.getAllCars().indexOf(car);
        System.out.println("Enter the property you would like to change:");
        String property = scanner.nextLine();

        System.out.println("Enter the new value of: " + property);
        String value = scanner.nextLine();

        switch (property) {
            case "name":
                car.name = value;
                break;
            case "manufacturer":
                car.manufacturer = value;
                break;
            case "type":
                car.type = value;
                break;
            default:
                System.out.println("Please provide a valid property");
                break;
        }


        showRoom.updateCarByManufacturer(carId, car);
        System.out.println(car.manufacturer + " updated successfully");
    }

    void updateCarByType() {
        System.out.println("Update car...");
        System.out.println("Enter car type:");
        String carType = scanner.nextLine();

        Car car = showRoom.findByType(carType);

        int carId = showRoom.getAllCars().indexOf(car);
        System.out.println("Enter the property you would like to change:");
        String property = scanner.nextLine();

        System.out.println("Enter the new value of " + property);
        String value = scanner.nextLine();

        switch (property) {
            case "name":
                car.name = value;
                break;
            case "manufacturer":
                car.manufacturer = value;
                break;
            case "type":
                car.type = value;
                break;
            default:
                System.out.println("Please provide a valid property");
                break;
        }

        showRoom.updateCarByType(carId, car);
        System.out.println(car.type + " updated successfully");
    }

    void searchByProperty() {

        System.out.println("Enter a property by number");
        System.out.println("1. Name ");
        System.out.println("2. Type");
        System.out.println("3. Manufacturer");

        String value = scanner.nextLine();

        switch (value){
            case "1":
                findByName();
                break;
            case "2":
                findByType();
                break;
            case "3":
                findByManufacturer();
                break;
            default:
                System.out.println("Please enter a valid value");
                break;



    }





    //This is a comment made on the remote server and isn't yet on my machine

    // This is the second comment.
    }
}
