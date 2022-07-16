package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCar extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("jonatan@gmail.com").setPassword("Jj12345$"));
            logger.info("user");
        }
    }

    @Test
    public void addNewCarSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Car car = Car.builder()
                .address("Haifa, Israel")
                .make("Mercedes")
                .model("W208")
                .year("2000")
                .engine("2.5")
                .fuel("Petrol")
                .gear("AT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("22-333-" + i)
                .price("65")
                .distanceIncluded("800")
                .features("type of features")
                .about("very nice car")
                .build();
logger.info("car is ---->"+car.toString());


        app.car().openCarForm();
        app.car().fillCarForm(car);
        app.car().attachPhoto("C:/Users/Admin/Documents/QA34_automation/ilCarro/ilCarro/mercedes w208.jpg");
        app.car().submit();
        Assert.assertEquals(app.car().getMessage(), "Car added");
        logger.info("check name--->"+car.getCarRegNumber());

    }

    @AfterMethod
    public void postCondition() {
        app.car().returnToHome();
    }
}