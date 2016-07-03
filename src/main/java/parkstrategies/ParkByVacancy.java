package parkstrategies;

import exception.ParkException;
import roles.Car;
import roles.Parkinglot;

import java.util.Collections;
import java.util.List;

public class ParkByVacancy implements ParkingStrategy {

    @Override
    public void park(Car car, List<Parkinglot> parkinglots) throws ParkException {

        Collections.sort(parkinglots, (o1, o2) -> new Integer(o1.getVacancy()).compareTo(o2.getVacancy()));

        Parkinglot parkLot = parkinglots.get(parkinglots.size() - 1);

        if (parkLot == null) {
            throw new ParkException("all the parkinglot is full");
        }

        parkLot.addCar(car);
    }
}
