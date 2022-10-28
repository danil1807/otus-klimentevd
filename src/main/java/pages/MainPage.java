package pages;


import annotations.UrlPrefix;
import components.base.CourseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@UrlPrefix("/")
//@Page("MainPage")
public class MainPage extends AbsBasePage<MainPage> {

  public MainPage(WebDriver driver) {
    super(driver);
  }

  private CourseComponent courseComponent;

  @FindBy(css = "a.transitional-main__courses-more")
  private WebElement moreCoursesBtn;

  public CourseComponent getCourseListComponent() {
    return courseComponent = new CourseComponent(driver);
  }

  public DevCoursesPage clickOnMoreCoursesBtn() {
    moreCoursesBtn.click();
    return new DevCoursesPage(driver);
  }
}
