package model;

import java.util.Calendar;

public class Magazine extends Product {

  private TCategory category;
  private int issuanceFrequency;
  private int subscriptions;

  /**
   *
   * @param category          category of the magazine
   * @param issuanceFrequency number of times the magazine is issued per year
   * @param subscriptions     number of subscriptions
   */
  public Magazine(String id, String name, int pages, String date, int pagesRead, float price, String image,
      String category, int issuanceFrequency, int subscriptions) {
    super(id, name, pages, date, pagesRead, price, image);
    this.category = TCategory.valueOf(category);
    this.issuanceFrequency = issuanceFrequency;
    this.subscriptions = subscriptions;
  }

  public String getId() {
    return this.id;
  }

  /**
   *
   * @param id unique id of the magazine
   */
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  /**
   *
   * @param name name of the magazine
   */
  public void setName(String name) {
    this.name = name;
  }

  public int getPages() {
    return this.pages;
  }

  /**
   *
   * @param pages number of pages of the magazine
   */
  public void setPages(int pages) {
    this.pages = pages;
  }

  public Calendar getDate() {
    return this.date;
  }

  public Calendar setDate(String date) {
    return getCalendar(date);
  }

  /**
   *
   * @param date date of the magazine
   */
  public void setDate(Calendar date) {
    this.date = date;
  }

  public TCategory getCategory() {
    return this.category;
  }

  /**
   *
   * @param category category of the magazine
   */
  public void setCategory(String category) {
    this.category = TCategory.valueOf(category);
  }

  public String getImage() {
    return this.image;
  }

  /**
   *
   * @param image image of the magazine
   */
  public void setImage(String image) {
    this.image = image;
  }

  public float getPrice() {
    return this.price;
  }

  /**
   *
   * @param price price of the magazine
   */
  public void setPrice(float price) {
    this.price = price;
  }

  public int getIssuanceFrequency() {
    return this.issuanceFrequency;
  }

  /**
   *
   * @param issuanceFrequency number of times the magazine is issued per year
   */
  public void setIssuanceFrequency(int issuanceFrequency) {
    this.issuanceFrequency = issuanceFrequency;
  }

  public int getSubscriptions() {
    return this.subscriptions;
  }

  /**
   *
   * @param subscriptions number of subscriptions
   */
  public void setSubscriptions(int subscriptions) {
    this.subscriptions = subscriptions;
  }

  public int getPagesRead() {
    return this.pagesRead;
  }

  /**
   *
   * @param pagesCount number of pages read
   */
  public void setPagesRead(int pagesCount) {
    pagesRead += pagesCount;
  }

  @Override
  public String toString() {
    String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
    String month = String.valueOf(date.get(Calendar.MONTH) + 1);
    String year = String.valueOf(date.get(Calendar.YEAR));
    String printDate = day + "/" + month + "/" + year;
    return "Magazine{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", pages=" + pages +
        ", date=" + printDate +
        ", category=" + category +
        ", image='" + image + '\'' +
        ", price=" + price +
        ", issuanceFrequency=" + issuanceFrequency +
        ", subscriptions=" + subscriptions +
        ", pagesRead=" + pagesRead +
        '}';
  }

}