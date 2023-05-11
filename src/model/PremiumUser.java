package model;

import java.util.ArrayList;
import java.util.Calendar;

public class PremiumUser extends User {

  private String name;
  private String id;
  private Calendar registrationDate;
  private ArrayList<String> products;

  public PremiumUser(String name, String id, Calendar registrationDate) {
    this.name = name;
    this.id = id;
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
  public void setRegistrationDate (Calendar registrationDate) {
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

}