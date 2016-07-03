package allocatestrategies;

import exception.ParkException;
import roles.Administrator;
import roles.Car;

import java.util.List;

public interface AllocateStrategy {
    void allocate(List<Administrator> administratorList, Car car) throws ParkException;
}
