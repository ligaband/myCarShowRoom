package cars;

import java.util.ArrayList;

public class ShowRoom {
    private ArrayList<Car> cars = new ArrayList<>();

    //add car
    public String addCar(Car car) {
        this.cars.add(car);
        return car.name + " Added successfully";
    }

    //getAllCars
    public ArrayList<Car> getAllCars() {
        return cars;
    }

    //getSingeCar
//    public Car getSingleCar(int carId){
//        return this.cars.get(carId);
//    }

    //the same getSingleCar but with String
    public String getSingleCar(int carId){
        try{
            Car car = this.cars.get(carId);
            return "\nCar Number: " + car.id + "\nCar Name: " + car.name + "\nCar Manufacturer: " + car.manufacturer +
                    "\nCar Type: " + car.type;

           }catch (Exception ex){
            return ("Unable to find car. Please try again with a valid car ID!");
        }
    }




    //removeCar

    public String removeCar(int carId){
        try{
            cars.remove(carId);
        }catch (Exception ex){
            return "Unable to remove specified car";
        }
        return "Car removed successfully";
    }

}
