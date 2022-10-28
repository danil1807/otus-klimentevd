package components.base;

import annotations.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CoursePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utils.DateUtil.getTheSoonestDate;

@Component("div.lessons__new-item-container")
public class CourseComponent extends AbsStaticComponent<CourseComponent> {

  public CourseComponent(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = "div.lessons__new-item-title_with-bg")
  private List<WebElement> courseNameList;

  @FindBy(css = "div.lessons__new-item-start")
  private List<WebElement> courseStartDataList;


//    public List<String> getCourseTitles() {
//        List<String> titles = new ArrayList<>();
//        for (WebElement course : courses) {
//            titles.add(course.getText());
//        }
//        System.out.println(titles);
//        var sortedList = titles.stream()
//                //.filter(p -> !p.getText().isEmpty())
//                .sorted(String::compareTo)
//                .collect(Collectors.toList());
//        System.out.println(sortedList);
//        return sortedList;
//    }
//
//    public List<String> sortCoursesByName(){
//        var sortedList = courseNameList.stream()
//                //.filter(p -> !p.getText().isEmpty())
//                .sorted(Comparator.comparing(WebElement::getText))
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//        System.out.println(sortedList);
//        return sortedList;
//    }


  public CoursePage goToCourseWithEarliestStartDate() {
    List<String> dates = new ArrayList<>();
    for (WebElement startDate : courseStartDataList) {
      dates.add(startDate.getText()); //added string containing date start to list
    }
    var soonestDate = getTheSoonestDate(dates);
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