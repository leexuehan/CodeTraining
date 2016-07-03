package parkstrategies;

import exception.ParkException;
import roles.Car;
import roles.Parkinglot;

import java.util.List;

public interface ParkingStrategy {
    void park(Car car, List<Parkinglot> parkinglots) throws ParkException;
}
