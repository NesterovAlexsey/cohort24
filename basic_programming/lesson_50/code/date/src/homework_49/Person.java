package homework_49;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Comparable<Person> {

  private static final DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
  private String name;
  private final Date birthday;

  // String birthday - дата рождения в виде строки в формате "ДД.ММ.ГГГГ".
  public Person(String name, String birthday) throws ParseException {
    this.name = name;
    this.birthday = formatter.parse(birthday);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthday() {
    return birthday;
  }

  @Override
  public String toString() {
    return name + " (дата рождения: " + formatter.format(birthday) + ")";
  }

  // если дата рождения БОЛЬШЕ, то человек МОЛОЖЕ - и должен быть "меньше"
  @Override
  public int compareTo(Person o) {
    if (birthday.after(o.birthday)) { // "наш" человек (this) родился ПОЗЖЕ
      return -1; // this < o
    }
    if (birthday.before(o.birthday)) { // this родился РАНЬШЕ
      return 1; // this > o
    }
    return 0; // не меньше и не больше, значит, равно
  }
}
