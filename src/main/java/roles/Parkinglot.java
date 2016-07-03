package roles;

import java.util.HashMap;
import java.util.Map;

public class Parkinglot {

    private int MAX_CAPACITY = 10;

    private Map<String, Car> carTable = new HashMap<>();

    private int currentCapacity = 0;

    public Parkinglot() {

    }


    public void addCar(Car car) {
        if (getCurrentCapacity() < MAX_CAPACITY) {
            carTable.put(car.getCarId(), car);
            currentCapacity++;
        }
    }

    public Car getCar(String carId) {
        Car car = carTable.get(carId);
        carTable.remove(carId);
        currentCapacity--;
        return car;
    }

    public boolean hasVacancies() {
        return currentCapacity < MAX_CAPACITY;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    @ForTest
    public void setCurrentCapacity(int currentCapacity){
        this.currentCapacity = currentCapacity;
    }

    public int getVacancy() {
        return MAX_CAPACITY - currentCapacity;
    }

    public double getVacancyRate() {
        return (MAX_CAPACITY - currentCapacity) / MAX_CAPACITY;
    }


    public void setCapacity(int capacity) {
        this.MAX_CAPACITY = capacity;
    }

    public int getCapacity() {
        return this.MAX_CAPACITY;
    }
}
