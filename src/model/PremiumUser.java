package model;

import java.util.ArrayList;
import java.util.Calendar;

public class PremiumUser extends User {

  private String name;
  private String id;
  private Calendar registrationDate;
  private ArrayList<String> products = new ArrayList<>();

  public PremiumUser(String id, String name, Calendar registrationDate) {
    this.id = id;
    this.name = name;
    this.registrationDate = registrationDate;
  }

  public String getName() {
    return this.name;
  }

  /**
   *
   * @param name name of the user
   */
  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return this.id;
  }

  /**
   *
   * @param id unique id of the user
   */
  public void setId(String id) {
    this.id = id;
  }

  public Calendar getRegistrationDate() {
    return this.registrationDate;
  }

  /**
   *
   * @param registrationDate date of registration
   */
  public void setRegistrationDate(Calendar registrationDate) {
    this.registrationDate = registrationDate;
  }

  public ArrayList<String> getProducts() {
    return this.products;
  }

  /**
   *
   * @param productId products bought by the user
   */
  public void setProduct(String productId) {
    this.products.add(productId);
  }

  @Override
  public String toString() {
    String day = String.valueOf(registrationDate.get(Calendar.DAY_OF_MONTH));
    String month = String.valueOf(registrationDate.get(Calendar.MONTH) + 1);
    String year = String.valueOf(registrationDate.get(Calendar.YEAR));
    String date = day + "/" + month + "/" + year;
    return "name='" + name + '\'' +
        ", id='" + id + '\'' +
        ", registrationDate=" + date +
        ", products=" + products;
  }
}