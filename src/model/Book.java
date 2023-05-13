package model;

import java.util.Calendar;

/**
 * Class that represents a book.
 */
public class Book extends Product {

  private String review;
  private TGenre genre;
  private int soldCopies;

  /**
   * constructor of the book class
   * @param id        id of the book
   * @param name      name of the book
   * @param pages     number of pages of the book
   * @param date      date of the book
   * @param pagesRead number of pages read of the book
   * @param price     price of the book
   * @param image     image of the book
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

  /**
   *
   * setter for date
   * @param date date of the book
   * @return date Calendar
   */ 
  public Calendar setDate(String date) {
    return getCalendar(date);
  }

  /**
   *
   * getter for id
   * @return id String
   */
  public String getId() {
    return this.id;
  }

  /**
   *
   * setter for id
   * @param id unique id of the book
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * 
   * getter for name
   * @return name String
   */
  public String getName() {
    return this.name;
  }

  /**
   *
   * setter for name
   * @param name name of the book
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   *
   * getter for pages
   * @return pages int
   */
  public int getPages() {
    return this.pages;
  }

  /**
   *
   * getter for pages
   * @param pages number of pages of the book
   */
  public void setPages(int pages) {
    this.pages = pages;
  }

  /**
   *
   * getter for review
   * @return review String
   */
  public String getReview() {
    return this.review;
  }

  /**
   * 
   * setter for review
   * @param review short review of the book
   */
  public void setReview(String review) {
    this.review = review;
  }

  /**
   *
   * getter for date
   * @return date Calendar
   */
  public Calendar getDate() {
    return this.date;
  }

  /**
   *
   * setter for date
   * @param date date of the book
   */
  public void setDate(Calendar date) {
    this.date = date;
  }

  /**
   *
   * getter for genre
   * @return genre TGenre
   */
  public TGenre getGenre() {
    return this.genre;
  }

  /**
   *
   * setter for genre
   * @param genre genre of the book
   */
  public void setGenre(String genre) {
    this.genre = TGenre.valueOf(genre);
  }

  /**
   *
   * getter for image
   * @return image String
   */
  public String getImage() {
    return this.image;
  }

  /**
   *
   * setter for image
   * @param image image of the book
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   *
   * getter for soldCopies
   * @return soldCopies int
   */
  public int getSoldCopies() {
    return this.soldCopies;
  }

  /**
   *
   * setter for soldCopies
   * @param soldCopies number of sold copies
   */
  public void setSoldCopies(int soldCopies) {
    this.soldCopies = soldCopies;
  }

  /**
   *
   * getter for price
   * @return price float
   */
  public float getPrice() {
    return this.price;
  }

  /**
   *
   * setter for price
   * @param price price of the book
   */
  public void setPrice(float price) {
    this.price = price;
  }

  /**
   *
   * getter for pagesRead
   * @return pagesRead int
   */
  public int getPagesRead() {
    return this.pagesRead;
  }

  /**
   *
   * setter for pagesRead
   * @param pagesRead number of pages read
   */
  public void setPagesRead(int pagesRead) {
    this.pagesRead = pagesRead;
  }

  /**
   * Method that returns a string with the book's information.
   * @return a string with the book's information.
   */
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