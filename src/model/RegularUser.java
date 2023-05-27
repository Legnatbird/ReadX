package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * Class that represents a regular user.
 */
public class RegularUser extends User implements Advertisable {

  private final ArrayList<String> products = new ArrayList<>(25);
  private String id;
  private String name;
  private Calendar registrationDate;
  private int booksCount;
  private int magazineCount;
  private int index = 0;
  private final String[] ads = {
      "Subscribe to Combo Plus and get Disney+ and Star+ at an incredible price!",
      "Now your pets have a favorite app: Laika. The best products for your furry friend.",
      "It's our anniversary! Visit your nearest Éxito and be surprised with the best offers."
  };

  /**
   * 
   * constructor of the regular user class
   * 
   * @param id               id of the user
   * @param name             name of the user
   * @param registrationDate date of registration
   */
  public RegularUser(String id, String name, Calendar registrationDate) {
    this.id = id;
    this.name = name;
    this.registrationDate = registrationDate;
    for (int i = 0; i < 25; i++) {
      this.products.add("");
    }
  }

  /**
   * 
   * This method return a random ad.
   * 
   * @return a random ad
   */
  public String showAds() {
    int random = (int) (Math.random() * 3);
    return ads[random];
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
   * getter for id
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
   * getter for products
   * 
   * @return products bought by the user
   */
  public ArrayList<String> getProducts() {
    return this.products;
  }

  /**
   *
   * setter for products
   * 
   * @param productId products bought by the user
   */
  public void setProduct(String productId) {
    this.products.set(index ,productId);
    index++;
  }

  /**
   * 
   * getter for booksCount
   * 
   * @return number of books bought by the user
   */
  public int getBookCount() {
    return this.booksCount;
  }

  /**
   *
   * setter for booksCount
   * 
   * @param booksCount number of books bought by the user
   */
  public void setBookCount(int booksCount) {
    this.booksCount = booksCount;
  }

  /**
   * 
   * getter for magazineCount
   * 
   * @return number of magazines bought by the user
   */
  public int getMagazineCount() {
    return this.magazineCount;
  }

  /**
   *
   * setter for magazineCount
   * 
   * @param magazineCount number of magazines bought by the user
   */
  public void setMagazineCount(int magazineCount) {
    this.magazineCount = magazineCount;
  }

  /**
   * 
   * This method returns the user's information
   * 
   * @return a string with the user's information
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
        ", booksCount=" + booksCount +
        ", magazineCount=" + magazineCount;
  }
}