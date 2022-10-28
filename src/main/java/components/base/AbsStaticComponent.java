package components.base;

import annotations.Component;
import components.AbsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.annotation.Annotation;

public abstract class AbsStaticComponent<T> extends AbsComponent<T> {

  {
    validate();
  }

  public AbsStaticComponent(WebDriver driver) {
    super(driver);
  }

  protected By getComponentLocator() {
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


  public void validate() {
    waiter.waitForCondition(ExpectedConditions.presenceOfElementLocated(getComponentLocator()));
  }
}
