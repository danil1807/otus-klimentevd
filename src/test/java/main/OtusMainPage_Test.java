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

//TODO:Автотест со своими ожиданиями
//
//        Цель:
//        Реализовать на практике полученные знания, с использованием Actions и своих ожиданий.
//
//
//        Описание/Пошаговая инструкция выполнения домашнего задания:
//        Необходимо создать проект в Maven'e и реализовать:
//
//        1. Фабрику (WebDriverFactory), которая будет получать значение из окружения и запускать соответствующий браузер
//        Браузеры: Chrome, Firefox, Opera - done
//        2. Реализовать подсветку элементов перед нажатием, после нажатия вернуть данные в исходное состояние - done
//        3. На главно странице Otus'a снизу найти список курсов(популярные курсы, специализации, рекомендации) и реализовать:
//         - Метод фильтр по названию курса - done
//         - Метод выбора курса, стартующего раньше всех/позже всех (при совпадении дат - выбрать любой) при помощи reduce - done
//         - Реализовать движение мыши при помощи и выбор курса при помощи библиотеки Actions
//
//        Критерии оценки:
//        Максимальная оценка 10 баллов.
//
//        2 Балла за реализацию фабрики
//        2 балла за подсветку элементов, +2 балла за возврат страницы в исходное состояние
//        1 бал за реализацию фильтра, +1 бал за реализацию reduce'ра
//        2 балла за реализацию Actions и выбора цвета

//        1 бал за каждое вмешательство преподавателя для запуска/работы тестов
//        2 балла за не реализованное задание
//        Сдача:
//        Сдача происходит через git.
//        Необходимо приложить инструкцию (вариант, написать в readme.md) по запуску.
////