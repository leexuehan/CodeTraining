# ForDownloads
Here is an example for JUnit Test


    import length.*;
    import lengthTransformStrategy.Transform2Inch;
    import lengthTransformStrategy.Transform2Mile;
    import lengthTransformStrategy.Transform2Yard;
    import lengthTransformStrategy.Transform2Feet;
    import org.junit.Before;
    import org.junit.Test;
    import static junit.framework.Assert.*;
    import static org.hamcrest.MatcherAssert.assertThat;
    import static org.hamcrest.core.Is.is;

    public class LengthTransformerTest {

    Transform2Yard transform2Yard;
    Transform2Feet transform2Feet;
    Transform2Inch transform2Inch;
    Transform2Mile transform2Mile;

    Mile mile;
    Yard yard;
    Feet feet;
    Inch inch;

    @Before
    public void setUp() throws Exception {
        transform2Yard = new Transform2Yard();
        transform2Feet = new Transform2Feet();
        transform2Mile = new Transform2Mile();
        transform2Inch = new Transform2Inch();
        mile = new Mile(1);
        yard = new Yard(1);
        feet = new Feet(1);
        inch = new Inch(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 初始化负一Mile时抛出异常() {
        new Mile(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 初始化负一Yard时抛出异常() {
        new Yard(-1);
    }

    @Test
    public void 一Mile与1760Yard相等() {
        assertTrue(mile.equals(LengthTransformer.unitTransform(new Yard(1760), transform2Mile)));
    }

    @Test
    public void 一760Yard与1Mile相等() {
        LengthUnit yard = LengthTransformer.unitTransform(mile, transform2Yard);
        assertTrue(new Yard(1760).equals(yard));
    }

    @Test
    public void 一761Yard不等于1Mile() {
        assertFalse(new Yard(1761).lengthUnitCompare(mile));
    }

    @Test
    public void 一759Yard不等于1Mile() {
        assertFalse(new Yard(1759).lengthUnitCompare(mile));
    }

    @Test
    public void 一Mie不等于1759Yard() {
        assertFalse(mile.lengthUnitCompare(new Yard(1759)));
    }

    @Test
    public void 一Mie不等于1761Yard() {
        assertFalse(new Mile(1).lengthUnitCompare(new Yard(1761)));
    }

    @Test
    public void 三Feet等于1Yard() throws Exception {
        assertTrue(new Feet(3).equals(LengthTransformer.unitTransform(yard, transform2Feet)));
    }

    @Test
    public void 一Yard不等于4Feet() throws Exception {
        assertFalse(new Feet(4).equals(LengthTransformer.unitTransform(yard, transform2Feet)));
    }

    @Test
    public void 一Yard不等于2Feet() throws Exception {
        assertFalse(new Feet(2).equals(LengthTransformer.unitTransform(yard, transform2Feet)));
    }

    @Test
    public void 一Mile等于5280Feet() throws Exception {
        assertTrue(mile.equals(LengthTransformer.unitTransform(new Feet(5280), transform2Mile)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 初始化负一Feet时抛出异常() {
        new Feet(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 初始化负一Inch时抛出异常() {
        new Inch(-1);
    }

    @Test
    public void 一Mile等于63360Inch() throws Exception {
        assertTrue(new Inch(63360).equals(LengthTransformer.unitTransform(mile, transform2Inch)));
    }

    @Test
    public void 一Yard等于36Inch() throws Exception {
        assertTrue(new Inch(36).equals(LengthTransformer.unitTransform(yard, transform2Inch)));
    }

    @Test
    public void 一Feet等于12Inch() throws Exception {
        assertTrue(new Inch(12).equals(LengthTransformer.unitTransform(feet, transform2Inch)));
    }

}

