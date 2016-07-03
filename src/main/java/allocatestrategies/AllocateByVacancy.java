package allocatestrategies;

import exception.ParkException;
import roles.Administrator;
import roles.Car;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AllocateByVacancy implements AllocateStrategy {
    @Override
    public void allocate(List<Administrator> administratorList, Car car) throws ParkException {
        Collections.sort(administratorList, (o1, o2) -> new Integer(o1.getVacantPositionNum())
                .compareTo(o2.getVacantPositionNum()));
        Administrator administrator = administratorList.get(administratorList.size() - 1);
        administrator.park(car);
    }
}
