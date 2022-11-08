package components.base;

import static utils.DateUtil.getTheSoonestDateUsingReduce;

import annotations.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CoursePage;


@Component("div.lessons__new-item-container")
public class CourseComponent extends AbsStaticComponent<CourseComponent> {

  public CourseComponent(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = "div.lessons__new-item-title_with-bg")
  private List<WebElement> courseNameList;

  @FindBy(css = "div.lessons__new-item-start")
  private List<WebElement> courseStartDataList;

  public CoursePage goToCourseWithEarliestStartDate() {
    List<String> dates = new ArrayList<>();
    for (WebElement startDate : courseStartDataList) {
      dates.add(startDate.getText()); //added string containing date start to list
    }
    var soonestDate = getTheSoonestDateUsingReduce(dates);
    for (WebElement startDate : courseStartDataList) {
      if (startDate.getText().contains(soonestDate)) {
        startDate.click();
        break;
      }
    }
    return new CoursePage(driver);
  }

  public CoursePage clickOnCourseByTitle(String title) {
    var neededCourse = courseNameList
      .stream()
      .filter(p -> Objects.equals(p.getText(), title))
      .findFirst();
    neededCourse.get().click();
    return new CoursePage(driver);
  }
}