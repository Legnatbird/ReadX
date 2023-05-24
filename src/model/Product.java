package model;

import java.util.Calendar;

// TODO Implement comparable interface and override compareTo method

/**
 * 
 * Class that represents a product.
 */
public abstract class Product implements Comparable<Product> {
  /**
   * id of the product
   */
  protected String id;
  /**
   * name of the product
   */
  protected String name;
  /**
   * number of pages of the product
   */
  protected int pages;
  /**
   * date of the product
   */
  protected Calendar date;
  /**
   * number of pages read of the product
   */
  protected int pagesRead;
  /**
   * price of the product
   */
  protected float price;
  /**
   * image of the product
   */
  protected String image;

  /**
   * 
   * constructor of the product class
   * 
   * @param id        id of the product
   * @param name      name of the product
   * @param pages     number of pages of the product
   * @param date      date of the product
   * @param pagesRead number of pages read of the product
   * @param price     price of the product
   * @param image     image of the product
   */
  public Product(String id, String name, int pages, String date, int pagesRead, float price, String image) {
    this.id = id;
    this.name = name;
    this.pages = pages;
    this.date = setDate(date);
    this.pagesRead = pagesRead;
    this.price = price;
    this.image = image;
  }

  /**
   *
   * getter for id
   * 
   * @return id String
   */
  public abstract String getId();

  /**
   *
   * setter for id
   * 
   * @param id unique id of the product
   */
  public abstract void setId(String id);

  /**
   * 
   * getter for name
   * 
   * @return name of the product
   */
  public abstract String getName();

  /**
   *
   * setter for name
   * 
   * @param name name of the product
   */
  public abstract void setName(String name);

  /**
   *
   * number of pages of the product
   * 
   * @return number of pages of the product
   */
  public abstract int getPages();

  /**
   *
   * setter for pages
   * 
   * @param pages number of pages of the product
   */
  public abstract void setPages(int pages);

  /**
   *
   * getter for date
   * 
   * @return date of the product
   */
  public abstract Calendar getDate();

  /**
   *
   * setter for date
   * 
   * @param date date of the product
   * @return Calendar object
   */
  public abstract Calendar setDate(String date);

  /**
   *
   * getter for pages read
   * 
   * @return number of pages read of the product
   */
  public abstract int getPagesRead();

  /**
   *
   * setter for pages read
   * 
   * @param pagesCount number of pages read of the product
   */
  public abstract void setPagesRead(int pagesCount);

  /**
   *
   * getter for price
   * 
   * @return price of the product
   */
  public abstract float getPrice();

  /**
   *
   * setter for price
   * 
   * @param price price of the product
   */
  public abstract void setPrice(float price);

  /**
   *
   * getter for image
   * 
   * @return image of the product
   */
  public abstract String getImage();

  /**
   *
   * setter for image
   * 
   * @param image image of the product
   */
  public abstract void setImage(String image);

  /**
   * 
   * comparable method for sorting
   * 
   * @param product product to compare
   * @return int value
   */
  @Override
  public int compareTo(Product product) {
    return this.date.compareTo(product.date);
  }

  public int compareTo(Product product, String sortBy) {
    return this.pagesRead - product.pagesRead;
  }

  /**
   *
   * getter for calendar
   * 
   * @param date date of the product
   * @return Calendar object
   */
  Calendar getCalendar(String date) {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(0, 2)));
    cal.set(Calendar.MONTH, Integer.parseInt(date.substring(3, 5)));
    cal.set(Calendar.YEAR, Integer.parseInt(date.substring(6, 10)));
    return cal;
  }
}