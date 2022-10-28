package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoursePage extends AbsBasePage<CoursePage> {

  public CoursePage(WebDriver driver) {
    super(driver);
  }


  public void coursePageNameShouldBeSameAs(String courseTitle) {
    waiter.waitForCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.t-sociallinks")));
    assertTrue(courseTitle.equalsIgnoreCase(driver.getTitle()), "Course title we clicked and page header don't match");
  }
}
