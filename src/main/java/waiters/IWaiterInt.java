package waiters;

import org.openqa.selenium.support.ui.ExpectedCondition;

public interface IWaiterInt {

    long IMPLICITY_WAIT_SECONDS = Integer.getInteger(System.getProperty("webdriver.timeouts.implicitywait", "5000"))/1000;
    boolean waitForCondition(ExpectedCondition expectedCondition);
}
