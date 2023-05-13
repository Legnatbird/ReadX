package model;

import java.util.ArrayList;
import java.util.Calendar;

public class RegularUser extends User implements Advertisable {

  private final ArrayList<String> products = new ArrayList<>();
  private String id;
  private String name;
  private Calendar registrationDate;
  private int booksCount;
  private int magazineCount;
  private final String[] ads = {
    "Subscribe to Combo Plus and get Disney+ and Star+ at an incredible price!",
    "Now your pets have a favorite app: Laika. The best products for your furry friend.",
    "It's our anniversary! Visit your nearest Éxito and be surprised with the best offers."
};
    

  public RegularUser(String id, String name, Calendar registrationDate) {
    this.id = id;
    this.name = name;
    this.registrationDate = registrationDate;
  }

  public String showAds() {
    int random = (int) (Math.random() * 3);
    return ads[random];
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
    setBookCount(getBookCount() + 1);
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

  @Override
  public String toString() {

    String day = String.valueOf(registrationDate.get(Calendar.DAY_OF_MONTH));
    String month = String.valueOf(registrationDate.get(Calendar.MONTH) + 1);
    String year = String.valueOf(registrationDate.get(Calendar.YEAR));
    String date = day + "/" + month + "/" + year;
    return "name='" + name + '\'' +
        ", id='" + id + '\'' +
        ", registrationDate=" + date +
        ", products=" + products +
        ", booksCount=" + booksCount +
        ", magazineCount=" + magazineCount;
  }

}