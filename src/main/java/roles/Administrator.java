package roles;

import exception.DepartException;
import exception.ParkException;

public class Administrator {

    private ParkingBuilding parkingBuilding;

    public Administrator() {
    }

    public void addParkingBuilding(ParkingBuilding building){
        this.parkingBuilding = building;
    }

    public void park(Car car) throws ParkException {
        parkingBuilding.addCar(car);
    }

    public void park(Car car, String strategy) throws ParkException {
        parkingBuilding.addCar(car, strategy);
    }

    public Car depart(String carId) throws DepartException {
        return parkingBuilding.getCar(carId);
    }

    public boolean hasVacantParkinglot() {
        return parkingBuilding.hasVacantParkinglot();
    }

    public int getVacantPositionNum() {
        return parkingBuilding.getVacantPositionNum();

    }

    public double getVacancyRate() {
        return parkingBuilding.getVacancyRate();

    }
}
