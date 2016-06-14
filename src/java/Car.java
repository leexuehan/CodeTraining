
public class Car {
    private String carId;
    public Car(String carId) {
        this.carId = carId;
    }

    public String getCarId() {
        return carId;
    }

    public boolean equals(Car car){
        return this.getCarId() == car.getCarId();
    }
}
