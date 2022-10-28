package pages;

import annotations.UrlPrefix;
import annotations.UrlTemplate;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.StandardWaiter;


public abstract class AbsBasePage<T> {

  protected WebDriver driver;
  protected StandardWaiter waiter;


  public AbsBasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    waiter = new StandardWaiter(driver);
  }

  @FindBy(tagName = "h1")
  private WebElement header;

  public T pageHeaderShouldBeAs(String header) {
    Assertions.assertThat(this.header.getText().equals(header));
    return (T) this;
  }

  private String getUrlPrefix() {
    UrlPrefix urlAnnotation = getClass().getAnnotation(UrlPrefix.class);
    if (urlAnnotation != null) {
      return urlAnnotation.value();
    }
    return "";
  }

  private String getUrlTemplate() {
    UrlTemplate urlAnnotation = getClass().getAnnotation(UrlTemplate.class);
    if (urlAnnotation != null) {
      return urlAnnotation.value();
    }
    return "";
  }

  private String hostname = System.getProperty("webdriver.base.url");

  public T open() {
    String prefix = getUrlPrefix();
    if (!prefix.startsWith("/")) {
      prefix = "/" + prefix;
    }
    driver.get(hostname + prefix);
    return (T) this;
  }

  public T open(String... data) {
    String prefix = getUrlPrefix();
    String urlTemplate = getUrlTemplate();
    for (int i = 0; i < data.length; i++) {
      urlTemplate = urlTemplate.replace(String.format("{%d}", i + 1), data[i]);
    }
    if (prefix.isEmpty()) {
      driver.get(hostname);
    } else {
      driver.get(hostname + prefix + urlTemplate);
    }
    return (T) this;
  }
}
