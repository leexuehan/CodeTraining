
public class Administrator {
    public boolean park(Car car) {
        Parkinglot lot = Parkinglot.getInstance();
        return lot.addCar(car.getCarId(),car);
    }

    public Car depart(String carId) {
        Parkinglot lot = Parkinglot.getInstance();
        Car car = lot.getCar(carId);
        return car;
    }
}
