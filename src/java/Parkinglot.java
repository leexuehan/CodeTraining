import java.util.HashMap;
import java.util.Map;

public class Parkinglot {
    private final int MAX_CAPACITY = 10;

    private static Parkinglot parkinglot = new Parkinglot();

    private Map<String, Car> carTable = new HashMap<>();

    private int currentCapacity = 0;

    private Parkinglot(){

    }

    public static Parkinglot getInstance(){
        return parkinglot;
    }


    public boolean addCar(String carId, Car car) {
        if(getCurrentCapacity() < MAX_CAPACITY) {
            carTable.put(carId,car);
            currentCapacity++;
            return true;
        }
        return false;
    }

    public Car getCar(String carId) {
        if(getCurrentCapacity() > 0) {
            Car car = carTable.get(carId);
            carTable.remove(carId);
            currentCapacity--;
            return car;
        }
        return null;
    }

    public int getCurrentCapacity(){
        return currentCapacity;
    }

    @ForTest
    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }
}
