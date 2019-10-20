
import org.junit.jupiter.api.Test;

import static java.lang.invoke.MethodHandles.catchException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

final class AppTest {
    @Test
    void noSpeedChangeUnderStandardConditions()  {
        assertThat(App.getEngineSpeed(120, 20, false), is(120));
    }

    @Test
    void noSpeedChangeWhenGreaterThan200AndVeryClose()  {
        assertThat(App.getEngineSpeed(201, 1, false), is(200));
    }

    @Test
    void updateSpeedWhenFasterThan200AndParanoid()  {
        assertThat(App.getEngineSpeed(200, 1, true), is(100));
    }

    @Test
    void updateSpeedWhenFasterThan100AndNot()  {
        assertThat(App.getEngineSpeed(200, 0, false), is(100));
    }

    @Test
    void invalidDistanceToNextCar()  {
        try{
            int speed = App.getEngineSpeed(120, -1, false);
            assertThat(false, is(true));
        }catch(IllegalArgumentException e){
            assertThat(true, is(true));
        }
    }

    @Test
    void getCarPriceForFrequentCustomerLargeDiscount() {
        assertThat(App.getCarPrice(100, App.DiscountKind.LARGE, true), is(60));
    }

    @Test
    void getCarPriceForFrequentCustomerSmallDiscount() {
        assertThat(App.getCarPrice(100, App.DiscountKind.SMALL, true), is(80));
    }

    @Test
    void getCarPriceForFrequentCustomerNoneDiscount() {
        assertThat(App.getCarPrice(100, App.DiscountKind.NONE, true), is(100));
    }

    @Test
    void getCarPriceForNotFrequentCustomerLargeDiscount() {
        try{
            int price = App.getCarPrice(100, App.DiscountKind.LARGE, false);
            assertThat(false, is(true));
        }catch(IllegalArgumentException e){
            assertThat(true, is(true));
        }
    }

    @Test
    void getCarPriceForNotFrequentCustomerSmallDiscount() {
        assertThat(App.getCarPrice(100, App.DiscountKind.SMALL, false), is(90));
    }

    @Test
    void getCarPriceForNotFrequentCustomerNoneDiscount() {
        assertThat(App.getCarPrice(100, App.DiscountKind.NONE, false), is(100));
    }

    @Test
    void mainDoesntCrash() {
        App.main(new String[]{});
    }

}
