package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * Class that represents a user.
 */
public abstract class User {
  /**
   * 
   * constructor of the user class
   */
  public User() {};

  /**
   *
   * getter for name
   * 
   * @return name of the user
   */
  public abstract String getName();

  /**
   *
   * setter for name
   * 
   * @param name name of the user
   */
  public abstract void setName(String name);

  /**
   *
   * getter for id of the user
   * 
   * @return id of the user
   */
  public abstract String getId();

  /**
   *
   * setter for id
   * 
   * @param idNumber unique id of the user
   */
  public abstract void setId(String idNumber);

  /**
   *
   * getter for date
   * 
   * @return email of the user
   */
  public abstract Calendar getRegistrationDate();

  /**
   *
   * setter for date
   * 
   * @param registrationDate date of registration
   */
  public abstract void setRegistrationDate(Calendar registrationDate);

  /**
   *
   * getter for products bought by the user
   * 
   * @return products bought by the user
   */
  public abstract ArrayList<String> getProducts();

  /**
   *
   * setter for products bought by the user
   * 
   * @param productId product bought by the user
   */
  public abstract void setProduct(String productId);

}