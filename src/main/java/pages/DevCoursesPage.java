package pages;

import components.base.CourseComponent;
import org.openqa.selenium.WebDriver;

public class DevCoursesPage extends AbsBasePage<DevCoursesPage> {

  public DevCoursesPage(WebDriver driver) {
    super(driver);
  }

  private CourseComponent courseComponent;

  public CourseComponent getCourseListComponent() {
    return courseComponent = new CourseComponent(driver);
  }
}
