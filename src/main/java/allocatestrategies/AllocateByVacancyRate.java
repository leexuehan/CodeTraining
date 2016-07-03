package allocatestrategies;

import exception.ParkException;
import roles.Administrator;
import roles.Car;

import java.util.Collections;
import java.util.List;

public class AllocateByVacancyRate implements AllocateStrategy {
    @Override
    public void allocate(List<Administrator> administratorList, Car car) throws ParkException {
        Collections.sort(administratorList, (o1, o2) -> new Double(o1.getVacancyRate()).compareTo(o2.getVacancyRate()));
        Administrator administrator = administratorList.get(administratorList.size() - 1);
        administrator.park(car);
    }
}
