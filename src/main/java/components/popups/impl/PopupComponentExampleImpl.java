package components.popups.impl;

import components.popups.AbsPopupComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import waiters.StandardWaiter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
//class for future popups
public class PopupComponentExampleImpl<T> extends AbsPopupComponent<T> {

    public PopupComponentExampleImpl(WebDriver driver) {
        super(driver);
    }

    protected String popupSelector = "css selector";


}
