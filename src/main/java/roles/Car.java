package roles;

import java.util.Objects;

public class Car {
    private String carId;

    public Car(String carId) {
        this.carId = carId;
    }

    public String getCarId() {
        return carId;
    }

    public boolean equals(Car car){
        return Objects.equals(this.getCarId(), car.getCarId());
    }
}
