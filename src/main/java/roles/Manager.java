package roles;

import allocatestrategies.AllocateByOrder;
import allocatestrategies.AllocateByVacancy;
import allocatestrategies.AllocateByVacancyRate;
import allocatestrategies.AllocateStrategy;
import exception.ParkException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {

    private List<Administrator> administrators = new ArrayList<>();
    private Map<String, AllocateStrategy> strategyMap = new HashMap<>();


    public Manager() {
        initAllocateStrategyMap();
    }

    private void initAllocateStrategyMap() {
        strategyMap.put("BY_ORDER", new AllocateByOrder());
        strategyMap.put("BY_VACANCY", new AllocateByVacancy());
        strategyMap.put("BY_VACANCYRATE", new AllocateByVacancyRate());
    }

    public void addAdmin(Administrator administrator) {
        administrators.add(administrator);
    }

    public void allocateCars(Car car, String strategy) throws ParkException {
        AllocateStrategy allocateStrategy = strategyMap.get(strategy);
        if (allocateStrategy == null) {
            throw new ParkException("not support " + strategy + " allocate strategy");
        }
        allocateStrategy.allocate(administrators, car);
    }
}
