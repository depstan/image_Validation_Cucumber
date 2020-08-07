package stepdefinitions;

import org.junit.*;
import pageObjectModel.*;

public class Hooks {

    @Before
    public void initialize() throws InterruptedException {
        System.out.println("Opening Browser");
        Thread.sleep(2000);
    }

    @After
    public void end() throws InterruptedException {
        Thread.sleep(2000);
        driverFactory.quitDriver();
    }
}
