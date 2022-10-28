package waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandardWaiter implements IWaiterInt{

    private WebDriver driver = null;

    public StandardWaiter(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean waitForCondition(ExpectedCondition expectedCondition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        try{
            webDriverWait.until(expectedCondition);
            return true;
        } catch(Exception ex){
            return false;
        }
    }
}
