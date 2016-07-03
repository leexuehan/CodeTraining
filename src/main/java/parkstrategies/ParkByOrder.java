package parkstrategies;

import exception.ParkException;
import roles.Car;
import roles.Parkinglot;

import java.util.List;

public class ParkByOrder implements ParkingStrategy {

    @Override
    public void park(Car car, List<Parkinglot> parkinglots) throws ParkException {
        Parkinglot parkLot = null;
        for (Parkinglot lot : parkinglots) {
            if(lot.hasVacancies()) {
                parkLot = lot;
                break;
            }
        }

        if(parkLot == null) {
            throw new ParkException("all the parkinglot is full");
        }
        parkLot.addCar(car);

    }
}
