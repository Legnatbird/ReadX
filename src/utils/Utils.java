package utils;

import java.util.ArrayList;
import java.util.Scanner;

import model.PremiumUser;
import model.RegularUser;
import model.User;

public class Utils {
  public static final Scanner input = new Scanner(System.in);
  public static void print(Object uwu) {
    System.out.println(uwu);
  }

  public static ArrayList<User> getUsers() {
    String[] data = Fetch.getData();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> ids = new ArrayList<String>();

    for (int i = 0; i < data.length; i++) {
      if (data[i].equals("firstName")) {
        names.add(data[i + 2]);
      }
      if (data[i].equals("id")) {
        ids.add(data[i + 2]);
      }
    }
    //use names and ids to create users array using the User class constructor
    ArrayList<User> users = new ArrayList<User>();
    for (int i = 0; i < 5; i++) {
      users.add(new RegularUser(names.get(i), ids.get(i)));
    }
    for (int i = 5; i < 10; i++) {
        users.add(new PremiumUser(names.get(i), ids.get(i)));
    }
    return users;
  }
}
