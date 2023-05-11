package model;

import java.util.ArrayList;
import java.util.Calendar;

public class RegularUser extends User implements Advertisable {

  private String name;
  private String id;
  private Calendar registrationDate;
  private ArrayList<String> products;
  private int booksCount;
  private int magazineCount;

  public RegularUser(String name, String id, Calendar registrationDate) {
    this.name = name;
    this.id = id;
    this.registrationDate = registrationDate;
  }

  public String showAds() {
    // TODO - implement RegularUser.showAds
    throw new UnsupportedOperationException();
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

  public int getBookCount() {
    return this.booksCount;
  }

  /**
   *
   * @param booksCount number of books bought by the user
   */
  public void setBookCount(int booksCount) {
    this.booksCount = booksCount;
  }

  public int getMagazineCount() {
    return this.magazineCount;
  }

  /**
   *
   * @param magazineCount number of magazines bought by the user
   */
  public void setMagazineCount(int magazineCount) {
    this.magazineCount = magazineCount;
  }

}