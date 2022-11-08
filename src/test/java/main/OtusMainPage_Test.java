package main;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class OtusMainPage_Test {

  @Driver
  private WebDriver driver;

  private MainPage mainPage;

  @Test
  public void shouldOpenNeededCoursePage() {
    mainPage = new MainPage(driver);
    var courseName = "Специализация iOS Developer";
    mainPage.open()
      .getCourseListComponent()
      .clickOnCourseByTitle(courseName)
      .coursePageNameShouldBeSameAs(courseName);
  }

  @Test
  public void shouldOpenCourseWithSoonestStartDate() {
    mainPage = new MainPage(driver);
    mainPage.open()
      .clickOnMoreCoursesBtn()
      .getCourseListComponent()
      .goToCourseWithEarliestStartDate();
  }
}