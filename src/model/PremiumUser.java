package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * Class that represents a premium user.
 */
public class PremiumUser extends User {

  private String name;
  private String id;
  private Calendar registrationDate;
  private final ArrayList<String> products = new ArrayList<>();

  /**
   * constructor of the premium user class
   * 
   * @param id               id of the user
   * @param name             name of the user
   * @param registrationDate date of registration
   */
  public PremiumUser(String id, String name, Calendar registrationDate) {
    this.id = id;
    this.name = name;
    this.registrationDate = registrationDate;
  }

  /**
   * 
   * getter for name
   * 
   * @return name of the user
   */
  public String getName() {
    return this.name;
  }

  /**
   *
   * setter for name
   * 
   * @param name name of the user
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 
   * getter for id of the user
   * 
   * @return id of the user
   */
  public String getId() {
    return this.id;
  }

  /**
   *
   * setter for id
   * 
   * @param id unique id of the user
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * 
   * getter for date
   * 
   * @return date of registration
   */
  public Calendar getRegistrationDate() {
    return this.registrationDate;
  }

  /**
   *
   * setter for date
   * 
   * @param registrationDate date of registration
   */
  public void setRegistrationDate(Calendar registrationDate) {
    this.registrationDate = registrationDate;
  }

  /**
   *
   * getter for products bought by the user
   * 
   * @return products bought by the user
   */
  public ArrayList<String> getProducts() {
    return this.products;
  }

  /**
   *
   * setter for products bought by the user
   * 
   * @param productId products bought by the user
   */
  public void setProduct(String productId) {
    this.products.add(productId);
  }

  /**
   * 
   * This method returns the user's information
   * 
   * @return String with the user's information
   */
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