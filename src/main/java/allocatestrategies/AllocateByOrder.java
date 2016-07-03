package allocatestrategies;

import exception.ParkException;
import roles.Administrator;
import roles.Car;

import java.util.List;

public class AllocateByOrder implements AllocateStrategy {
    @Override
    public void allocate(List<Administrator> administratorList, Car car) throws ParkException {
        Administrator administrator = null;
        for(Administrator admin : administratorList) {
            if(admin.hasVacantParkinglot()) {
                administrator = admin;
                break;
            }
        }

        administrator.park(car);
    }
}
