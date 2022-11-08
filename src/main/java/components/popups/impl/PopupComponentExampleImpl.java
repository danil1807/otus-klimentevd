package components.popups.impl;

import components.popups.AbsPopupComponent;
import org.openqa.selenium.WebDriver;

//class for future popups
public class PopupComponentExampleImpl<T> extends AbsPopupComponent<T> {

  public PopupComponentExampleImpl(WebDriver driver) {
    super(driver);
  }

  protected String popupSelector = "css selector";


}
