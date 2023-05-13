package model;

import java.util.Calendar;

public abstract class Product {
  protected String id;
  protected String name;
  protected int pages;
  protected Calendar date;
  protected int pagesRead;
  protected float price;
  protected String image;

  /**
   *
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

  public abstract String getId();

  /**
   *
   * @param id unique id of the product
   */
  public abstract void setId(String id);

  public abstract String getName();

  /**
   *
   * @param name name of the product
   */
  public abstract void setName(String name);

  public abstract int getPages();

  /**
   *
   * @param pages number of pages of the product
   */
  public abstract void setPages(int pages);

  public abstract Calendar getDate();

  /**
   *
   * @param date date of the product
   */
  public abstract Calendar setDate(String date);

  public abstract int getPagesRead();

  /**
   *
   * @param pagesCount number of pages read of the product
   */
  public abstract void setPagesRead(int pagesCount);

  public abstract float getPrice();

  /**
   *
   * @param price price of the product
   */
  public abstract void setPrice(float price);

  public abstract String getImage();

  /**
   *
   * @param image image of the product
   */
  public abstract void setImage(String image);

  Calendar getCalendar(String date) {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(0, 2)));
    cal.set(Calendar.MONTH, Integer.parseInt(date.substring(3, 5)));
    cal.set(Calendar.YEAR, Integer.parseInt(date.substring(6, 10)));
    return cal;
  }
}