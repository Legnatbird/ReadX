package model;

import java.util.Calendar;

public class Book extends Product {
  private String review;
  private TGenre genre;
  private int soldCopies;

  /**
   *
   * @param review     short review of the book
   * @param genre      genre of the book
   * @param soldCopies number of sold copies
   */
  public Book(String id, String name, int pages, String date, int pagesRead, float price, String image, String review,
      String genre, int soldCopies) {
    super(id, name, pages, date, pagesRead, price, image);
    this.review = review;
    this.genre = TGenre.valueOf(genre);
    this.soldCopies = soldCopies;
  }

  public Calendar setDate(String date) {
    return getCalendar(date);
  }

  public String getId() {
    return this.id;
  }

  /**
   *
   * @param id unique id of the book
   */
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  /**
   *
   * @param name name of the book
   */
  public void setName(String name) {
    this.name = name;
  }

  public int getPages() {
    return this.pages;
  }

  /**
   *
   * @param pages number of pages of the book
   */
  public void setPages(int pages) {
    this.pages = pages;
  }

  public String getReview() {
    return this.review;
  }

  /**
   *
   * @param review short review of the book
   */
  public void setReview(String review) {
    this.review = review;
  }

  public Calendar getDate() {
    return this.date;
  }

  /**
   *
   * @param date date of the book
   */
  public void setDate(Calendar date) {
    this.date = date;
  }

  public TGenre getGenre() {
    return this.genre;
  }

  /**
   *
   * @param genre genre of the book
   */
  public void setGenre(String genre) {
    this.genre = TGenre.valueOf(genre);
  }

  public String getImage() {
    return this.image;
  }

  /**
   *
   * @param image image of the book
   */
  public void setImage(String image) {
    this.image = image;
  }

  public int getSoldCopies() {
    return this.soldCopies;
  }

  /**
   *
   * @param soldCopies number of sold copies
   */
  public void setSoldCopies(int soldCopies) {
    this.soldCopies = soldCopies;
  }

  public float getPrice() {
    return this.price;
  }

  /**
   *
   * @param price price of the book
   */
  public void setPrice(float price) {
    this.price = price;
  }

  public int getPagesRead() {
    return this.pagesRead;
  }

  /**
   *
   * @param pagesRead number of pages read
   */
  public void setPagesRead(int pagesRead) {
    this.pagesRead = pagesRead;
  }

  @Override
  public String toString() {
    String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
    String month = String.valueOf(date.get(Calendar.MONTH) + 1);
    String year = String.valueOf(date.get(Calendar.YEAR));
    String printDate = day + "/" + month + "/" + year;
    return "Book{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", pages=" + pages +
        ", review='" + review + '\'' +
        ", date=" + printDate +
        ", genre=" + genre +
        ", image='" + image + '\'' +
        ", price=" + price +
        ", soldCopies=" + soldCopies +
        ", pagesRead=" + pagesRead +
        '}';
  }
}