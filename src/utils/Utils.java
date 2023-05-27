package utils;

import java.util.ArrayList;
import java.util.Calendar;

import model.PremiumUser;
import model.RegularUser;
import model.User;

/**
 * 
 * Class that represents a utility class.
 */
public class Utils {
  /**
   * 
   * constructor of the utils class
   */
  public Utils() {}

  /**
   * 
   * method for get users from the api
   * 
   * @return users from the api
   */
  public static ArrayList<User> getUsers() {
    String[] data = Fetch.getData();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> ids = new ArrayList<>();

    for (int i = 0; i < data.length; i++) {
      if (data[i].equals("firstName")) {
        names.add(data[i + 2]);
      }
      if (data[i].equals("id")) {
        ids.add(data[i + 2].substring(20, 24));
      }
    }
    ArrayList<User> users = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      users.add(new RegularUser(ids.get(i), names.get(i), Calendar.getInstance()));
    }
    for (int i = 5; i < 10; i++) {
      users.add(new PremiumUser(ids.get(i), names.get(i), Calendar.getInstance()));
    }
    return users;
  }

  /**
   * 
   * method for get current date
   * 
   * @return current date
   */
  public static Calendar getCurrentDate() {
    return Calendar.getInstance();
  }
}
