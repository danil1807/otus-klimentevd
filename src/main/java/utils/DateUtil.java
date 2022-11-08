package utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

  private static String[] months = {"января", "февраля", "марта", "апреля",
    "мая", "июня", "июля", "августа",
    "сентября", "октября", "ноября", "декабря"};

  public static String getTheSoonestDate(List<String> strings) {
    List<Calendar> dates = new ArrayList<>();
    for (String string : strings) {
      var date = extractDateFromString(string);
      date.ifPresent(dates::add);
    }
    var soonestDate = dates.stream()
      .sorted()
      .findFirst();
    return convertDateToString(soonestDate.get());
  }

  public static String getTheSoonestDateUsingReduce(List<String> strings) {
    List<Calendar> dates = new ArrayList<>();
    for (String string : strings) {
      var date = extractDateFromString(string);
      date.ifPresent(dates::add);
    }

    var result = dates.stream()
      .reduce((date1, date2) -> date1.compareTo(date2) <= 0 ? date1 : date2);
    return convertDateToString(result.get());
  }

  public static String getTheLatestDate(List<String> strings) throws ParseException {
    List<Calendar> dates = new ArrayList<>();
    for (String string : strings) {
      var date = extractDateFromString(string);
      date.ifPresent(dates::add);
    }
    var latestDate = dates.stream().max(Comparator.naturalOrder());
    return convertDateToString(latestDate.get());
  }

  private static String convertDateToString(Calendar date) {
    var day = date.get(Calendar.DAY_OF_MONTH);
    var month = date.get(Calendar.MONTH);
    var year = date.get(Calendar.YEAR);

    var string = "С " + day + " " + months[month];
    if (year != LocalDate.now().getYear()) {
      string = "С " + day + " " + months[month] + " " + year + " года";
    }
    return string;
  }


  private static Optional<Calendar> extractDateFromString(String string) {
    try {
      Pattern pattern = Pattern.compile("[0-9]+");
      Matcher matcher = pattern.matcher(string);

      List<String> values = new ArrayList<>();
      while (matcher.find()) {
        values.add(string.substring(matcher.start(), matcher.end()));
      }
      var day = Integer.parseInt(values.get(0));
      var year = LocalDate.now().getYear();
      if (values.size() > 1) {
        year = Integer.parseInt(values.get(1));
      }
      var month = -1;
      for (int i = 0; i < months.length; i++) {
        if (string.contains(months[i])) {
          month = i;
          break;
        }
      }
      return Optional.of(new GregorianCalendar(year, month, day));
    } catch (Exception e) {
      return Optional.empty();
    }

  }


}
