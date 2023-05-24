package model;

import java.util.Calendar;

/**
 * 
 * Class that represents a magazine.
 */
public class Magazine extends Product {

  private TCategory category;
  private int issuanceFrequency;
  private int subscriptions;

  /**
   *
   * constructor of the magazine class
   * 
   * @param id                id of the magazine
   * @param name              name of the magazine
   * @param pages             number of pages of the magazine
   * @param date              date of the magazine
   * @param pagesRead         number of pages read of the magazine
   * @param price             price of the magazine
   * @param image             image of the magazine
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

  /**
   * 
   * getter for id
   * 
   * @return id String
   */
  public String getId() {
    return this.id;
  }

  /**
   *
   * setter for id
   * 
   * @param id unique id of the magazine
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * 
   * getter for name
   * 
   * @return name of the magazine
   */
  public String getName() {
    return this.name;
  }

  /**
   *
   * setter for name
   * 
   * @param name name of the magazine
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 
   * getter for pages
   * 
   * @return number of pages of the magazine
   */
  public int getPages() {
    return this.pages;
  }

  /**
   *
   * setter for pages
   * 
   * @param pages number of pages of the magazine
   */
  public void setPages(int pages) {
    this.pages = pages;
  }

  /**
   * 
   * getter for date
   * 
   * @return date of the magazine
   */
  public Calendar getDate() {
    return this.date;
  }

  /**
   * 
   * setter for date
   * 
   * @param date date of the magazine
   * @return date of the magazine
   */
  public Calendar setDate(String date) {
    return getCalendar(date);
  }

  /**
   *
   * setter for date
   * 
   * @param date date of the magazine
   */
  public void setDate(Calendar date) {
    this.date = date;
  }

  /**
   * 
   * getter for category
   * 
   * @return category of the magazine
   */
  public TCategory getCategory() {
    return this.category;
  }

  /**
   *
   * setter for category
   * 
   * @param category category of the magazine
   */
  public void setCategory(String category) {
    this.category = TCategory.valueOf(category);
  }

  /**
   * 
   * getter for pagesRead
   * 
   * @return image of the magazine
   */
  public String getImage() {
    return this.image;
  }

  /**
   *
   * setter for image
   * 
   * @param image image of the magazine
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * 
   * getter for pagesRead
   * 
   * @return price of the magazine
   */
  public float getPrice() {
    return this.price;
  }

  /**
   *
   * setter for price
   * 
   * @param price price of the magazine
   */
  public void setPrice(float price) {
    this.price = price;
  }

  /**
   * 
   * getter for pagesRead
   * 
   * @return number of times the magazine is issued per year
   */
  public int getIssuanceFrequency() {
    return this.issuanceFrequency;
  }

  /**
   *
   * setter for issuanceFrequency
   * 
   * @param issuanceFrequency number of times the magazine is issued per year
   */
  public void setIssuanceFrequency(int issuanceFrequency) {
    this.issuanceFrequency = issuanceFrequency;
  }

  /**
   * 
   * getter for subscriptions
   * 
   * @return number of subscriptions
   */
  public int getSubscriptions() {
    return this.subscriptions;
  }

  /**
   *
   * setter for subscriptions
   * 
   * @param subscriptions number of subscriptions
   */
  public void setSubscriptions(int subscriptions) {
    this.subscriptions = subscriptions;
  }

  /**
   * 
   * getter for pagesRead
   * 
   * @return number of pages read
   */
  public int getPagesRead() {
    return this.pagesRead;
  }

  /**
   *
   * setter for pagesRead
   * 
   * @param pagesCount number of pages read
   */
  public void setPagesRead(int pagesCount) {
    pagesRead += pagesCount;
  }

  /**
   * 
   * getter for pagesRead
   * 
   * @return String representation of the magazine
   */
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