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

    void showMenu(){

        String userInput = "";

        do{
            System.out.println("\nWelcome to the showroom, please choose an activity: ");
            System.out.println("1. Add car");
            System.out.println("2. View all cars");
            System.out.println("3. View single car");
            System.out.println("4. Remove car");
            System.out.println("\nEnter Quit to end program....");

            System.out.println("Choose a number:");
            userInput = scanner.nextLine();
            switch (userInput){
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
                default:
                    break;
            }
        }while(!userInput.equalsIgnoreCase("Quit"));
        return;
    }
    void addCar(){

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
    void viewAllCars(){
        ArrayList<Car> allCars = showRoom.getAllCars();

        System.out.println("\nAll available cars");
        System.out.println("Car name\tManufacturer\tCar type");
        for (Car car: allCars){
            System.out.println(car.name + "\t\t\t" + car.manufacturer + " \t\t\t" + car.type );
        }
    }
    //create method to view single car
    void viewSingleCar(){
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
    void removeCar(){

        System.out.println("Please provide a car ID to remove a car: ");


        int removeCar = scanner.nextInt();
        String massage = showRoom.removeCar(removeCar);
        System.out.println(massage);

    }
    
    //This is a comment made on the remote server and isn't yet on my machine 
    
    // This is the second comment

}
