package components.popups;

import annotations.Component;
import components.AbsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public abstract class AbsPopupComponent<T> extends AbsComponent<T> implements IPopup<T> {
    public AbsPopupComponent(WebDriver driver) {
        super(driver);
    }
    @Override
    public T shouldNotBeVisible() {
        assertTrue(waiter.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(getComponentLocator())));
        return (T) this;
    }

    @Override
    public T shouldBeVisible() {
        assertTrue(waiter.waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(getComponentLocator())));
        return (T) this;
    }

    private By getComponentLocator() {
        Class clazz = this.getClass();
        String locatorValue = "";
        if (clazz.isAnnotationPresent(Component.class)) {
            Annotation component = clazz.getAnnotation(Component.class);
            locatorValue = ((Component) component).value();
            if (locatorValue.startsWith("/")) {
                return By.xpath(locatorValue);
            } else {
                return By.cssSelector(locatorValue);
            }
        }
        return null;
    }
}
