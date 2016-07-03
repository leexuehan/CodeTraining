package roles;

import exception.DepartException;
import exception.ParkException;
import parkstrategies.ParkByOrder;
import parkstrategies.ParkByVacancy;
import parkstrategies.ParkByVacancyRate;
import parkstrategies.ParkingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBuilding {
    private List<Parkinglot> parkinglotList = new ArrayList<>();
    private static Map<String, ParkingStrategy> strategyMap = new HashMap<>();

    public ParkingBuilding(){
        initStrategyMap();
    }

    private void initStrategyMap() {
        strategyMap.put("BY_ORDER", new ParkByOrder());
        strategyMap.put("BY_VACANCY", new ParkByVacancy());
        strategyMap.put("BY_VACANCY_RATE", new ParkByVacancyRate());
    }


    public void addParkinglot(Parkinglot lot){
        parkinglotList.add(lot);
    }

    public void addCar(Car car, String strategy) throws ParkException {
        ParkingStrategy parkingStrategy = strategyMap.get(strategy);
        if (strategy == null) {
            throw new ParkException("not support " + strategy + "strategy");
        }

        parkingStrategy.park(car, parkinglotList);
    }


    public Car getCar(String carId) throws DepartException {
        Car car = null;
        for (Parkinglot lot : parkinglotList) {
            car = lot.getCar(carId);
            if(car != null)
                break;
        }
        if (car == null) {
            throw new DepartException("depart car failed!");
        }
        return car;
    }

    public void addCar(Car car) throws ParkException {
        new ParkByOrder().park(car,parkinglotList);
    }

    public int getVacantPositionNum() {
        int vacantPositionNum = 0;
        for (Parkinglot lot : parkinglotList) {
            vacantPositionNum += lot.getVacancy();
        }
        return vacantPositionNum;
    }

    public double getVacancyRate() {
        int totalPositionNum = 0;
        int vancatPostionNum = 0;
        for (Parkinglot lot : parkinglotList) {
            totalPositionNum += lot.getCapacity();
            vancatPostionNum += lot.getVacancy();
        }
        return vancatPostionNum / totalPositionNum;
    }

    public boolean hasVacantParkinglot(){
        for (Parkinglot lot : parkinglotList) {
            if (lot.hasVacancies()) {
                return true;
            }
        }
        return false;
    }
}
