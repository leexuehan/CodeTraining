
import exception.DepartException;
import exception.ParkException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import roles.*;

import static org.junit.Assert.assertTrue;

public class ParkinglotTest {

    private Parkinglot lot1;
    private Parkinglot lot2;
    private Parkinglot lot3;
    private Administrator administrator;
    private Manager manager;
    private ParkingBuilding parkingBuilding;

    @Before
    public void setUp() {
        lot1 = new Parkinglot();
        lot2 = new Parkinglot();
        lot3 = new Parkinglot();
        administrator = new Administrator();
        manager = new Manager();
        parkingBuilding = new ParkingBuilding();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void should_park_car_successfully_when_parkinglot_is_NOT_full() throws ParkException, DepartException {
        Car car = new Car("1987");
        parkingBuilding.addParkinglot(lot1);
        administrator.addParkingBuilding(parkingBuilding);

        administrator.park(car);

        assertTrue(administrator.depart("1987").equals(car));
    }

    @Test(expected = ParkException.class)
    public void should_park_car_failed_when_parkinglot_is_full() throws ParkException {
        parkingBuilding.addParkinglot(lot1);
        administrator.addParkingBuilding(parkingBuilding);
        lot1.setCapacity(0);
        Car car = new Car("1987");
        administrator.park(car);

    }

    @Test
    public void should_depart_car_successfully_when_car_is_in_parkinglot() throws ParkException, DepartException {
        Car car = new Car("1987");
        parkingBuilding.addParkinglot(lot1);
        administrator.addParkingBuilding(parkingBuilding);
        administrator.park(car);
        assertTrue(administrator.depart("1987").equals(car));

    }

    @Test(expected = DepartException.class)
    public void should_depart_car_failed_when_car_is_NOT_in_parkinglot() throws DepartException {
        parkingBuilding.addParkinglot(lot1);
        administrator.addParkingBuilding(parkingBuilding);
        administrator.depart("1987");

    }


    @Test
    public void should_admin_park_car_in_parkinglot_by_order() throws ParkException {
        lot1.setCapacity(1);
        lot2.setCapacity(1);
        lot3.setCapacity(1);
        parkingBuilding.addParkinglot(lot1);
        parkingBuilding.addParkinglot(lot2);
        parkingBuilding.addParkinglot(lot3);
        administrator.addParkingBuilding(parkingBuilding);

        Car car1 = new Car("1989");
        Car car2 = new Car("1990");
        Car car3 = new Car("1991");

        administrator.park(car1,"BY_ORDER");
        administrator.park(car2,"BY_ORDER");
        administrator.park(car3,"BY_ORDER");

        assertTrue(lot1.getCar("1989").equals(car1));
        assertTrue(lot2.getCar("1990").equals(car2));
        assertTrue(lot3.getCar("1991").equals(car3));

    }

    @Test
    public void should_admin_park_car_in_parkinglot_by_vacancy() throws ParkException {
        lot1.setCapacity(2);
        lot2.setCapacity(3);
        lot3.setCapacity(5);
        lot1.addCar(new Car("112"));
        lot2.addCar(new Car("113"));
        lot3.addCar(new Car("114"));
        parkingBuilding.addParkinglot(lot1);
        parkingBuilding.addParkinglot(lot2);
        parkingBuilding.addParkinglot(lot3);
        administrator.addParkingBuilding(parkingBuilding);
        Car car = new Car("1984");

        administrator.park(car,"BY_VACANCY");

        assertTrue(lot3.getCar("1984").equals(car));

    }

    @Test
    public void shout_admin_park_car_in_parkinglot_by_vacancyrate() throws ParkException {
        lot1.setCapacity(2);
        lot2.setCapacity(3);
        lot3.setCapacity(5);
        lot1.addCar(new Car("112"));
        lot2.addCar(new Car("113"));
        lot2.addCar(new Car("114"));
        lot3.addCar(new Car("115"));
        parkingBuilding.addParkinglot(lot1);
        parkingBuilding.addParkinglot(lot2);
        parkingBuilding.addParkinglot(lot3);
        administrator.addParkingBuilding(parkingBuilding);
        Car car = new Car("1984");

        administrator.park(car,"BY_VACANCY_RATE");

        assertTrue(lot3.getCar("1984").equals(car));
    }


    @Test
    public void should_manager_allocate_car_to_admin_by_order() throws ParkException, DepartException {
        Administrator admin1 = new Administrator();
        ParkingBuilding building1 = new ParkingBuilding();
        lot1.setCapacity(2);
        lot2.setCapacity(3);
        building1.addParkinglot(lot1);
        building1.addParkinglot(lot2);
        admin1.addParkingBuilding(building1);

        Administrator admin2 = new Administrator();
        Parkinglot lot3 = new Parkinglot();
        Parkinglot lot4 = new Parkinglot();
        lot3.setCapacity(2);
        lot4.setCapacity(2);
        ParkingBuilding building2 = new ParkingBuilding();
        building2.addParkinglot(lot3);
        building2.addParkinglot(lot4);
        admin2.addParkingBuilding(building2);

        Car car = new Car("1990");

        manager.addAdmin(admin1);
        manager.addAdmin(admin2);

        manager.allocateCars(car,"BY_ORDER");

        assertTrue(admin1.depart("1990").equals(car));
    }

    @Test
    public void should_manager_allocate_car_to_admin_by_vancancy() throws ParkException, DepartException {
        Administrator admin1 = new Administrator();
        Administrator admin2 = new Administrator();
        lot1.setCapacity(2);
        lot2.setCapacity(3);
        parkingBuilding.addParkinglot(lot1);
        parkingBuilding.addParkinglot(lot2);
        admin1.addParkingBuilding(parkingBuilding);


        Parkinglot lot3 = new Parkinglot();
        lot3.setCapacity(2);
        Parkinglot lot4 = new Parkinglot();
        lot4.setCapacity(2);
        parkingBuilding.addParkinglot(lot3);
        parkingBuilding.addParkinglot(lot4);
        admin2.addParkingBuilding(parkingBuilding);



        Car car = new Car("1990");
        manager.addAdmin(admin1);
        manager.addAdmin(admin2);

        manager.allocateCars(car,"BY_VACANCY");

        assertTrue(admin1.depart("1990").equals(car));
    }

    @Test
    public void should_manager_allocate_car_to_admin_by_vacancyrate() throws ParkException, DepartException {
        Administrator admin1 = new Administrator();
        Administrator admin2 = new Administrator();
        lot1.setCapacity(2);
        lot1.setCurrentCapacity(1);
        lot2.setCapacity(3);
        lot2.setCurrentCapacity(2);
        parkingBuilding.addParkinglot(lot1);
        parkingBuilding.addParkinglot(lot2);
        admin1.addParkingBuilding(parkingBuilding);

        Parkinglot lot3 = new Parkinglot();
        lot3.setCapacity(2);
        Parkinglot lot4 = new Parkinglot();
        lot4.setCapacity(2);
        lot4.setCurrentCapacity(1);
        parkingBuilding.addParkinglot(lot3);
        parkingBuilding.addParkinglot(lot4);
        admin2.addParkingBuilding(parkingBuilding);


        Car car = new Car("1990");
        manager.addAdmin(admin1);
        manager.addAdmin(admin2);

        manager.allocateCars(car,"BY_VACANCYRATE");

        assertTrue(admin2.depart("1990").equals(car));
    }

}
