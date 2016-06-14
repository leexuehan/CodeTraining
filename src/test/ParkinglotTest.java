import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ParkinglotTest {
    @Test
    public void should_park_car_successfully_when_parkinglot_is_NOT_full(){
        Parkinglot lot = Parkinglot.getInstance();
        Administrator administrator = new Administrator();
        Car car = new Car("1987");
        administrator.park(car);

        assertTrue(lot.getCar("1987").equals(car));
    }

    @Test
    public void should_park_car_failed_when_parkinglot_is_full(){
        Parkinglot lot = Parkinglot.getInstance();
        Administrator administrator = new Administrator();
        lot.setCurrentCapacity(10);
        Car car = new Car("1987");
        assertFalse(administrator.park(car));

    }

    @Test
    public void should_depart_car_successfully_when_car_is_in_parkinglot(){
        Car car = new Car("1987");
        Administrator administrator = new Administrator();
        administrator.park(car);
        assertTrue(administrator.depart("1987").equals(car));

    }

    @Test
    public void should_depart_car_failed_when_car_is_NOT_in_parkinglot(){
        Administrator administrator = new Administrator();
        assertNull(administrator.depart("1987"));

    }






}
