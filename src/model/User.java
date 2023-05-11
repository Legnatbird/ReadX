package model;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class User {
  public User(){};

  public abstract String getName();

  /**
   *
   * @param name name of the user
   */
  public abstract void setName(String name);

  public abstract String getId();

  /**
   *
   * @param idNumber unique id of the user
   */
  public abstract void setId(String idNumber);

  public abstract Calendar getRegistrationDate();

  /**
   *
   * @param registrationDate date of registration
   */
  public abstract void setRegistrationDate(Calendar registrationDate);

  public abstract ArrayList<String> getProducts();

  /**
   *
   * @param productId product bought by the user
   */
  public abstract void setProduct(String productId);

}