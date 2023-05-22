package model;

import java.util.ArrayList;
import java.util.Random;
import utils.Utils;

// TODO - replace all get methods of the arraylist return a int with the index of the object, and with this index get the object for work with it more easily
/**
 * 
 * Class that represents a readX controller.
 */
public class ReadXController {

  /**
   * 
   * ArrayList of users.
   */
  private ArrayList<User> users = new ArrayList<>();
  /**
   * 
   * ArrayList of products.
   */
  private final ArrayList<Product> products = new ArrayList<>();

  /**
   * 
   * constructor of the readX controller class
   */
  public ReadXController() {
  }

  /**
   *
   * This method register a user in the system.
   * @param name name of the user
   * @param id id of the user
   * @param type type of the user
   * @return a message that indicates if the user was registered successfully or not
   */
  public String RegisterUser(String name, String id, boolean type) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i) == null) {
        if (type) {
          users.set(i, new PremiumUser(name, id, Utils.getCurrentDate()));
        } else {
          users.set(i, new RegularUser(name, id, Utils.getCurrentDate()));
        }
        return "User registered successfully";
      }
    }
    return "Error: There is no space for more users";
  }

  /**
   *
   * This method register a magazine in the system.
   * @param id                id of the book
   * @param name              name of the book
   * @param pages             number of pages of the book
   * @param date              date of publication of the book
   * @param price             price of the book
   * @param image             image of the book
   * @param category          category of the book
   * @param pagesRead         number of pages read of the book
   * @param issuanceFrequency frequency of issuance of the book
   * @param subscriptions     number of subscriptions of the book
   * @return a message that indicates if the magazine was registered successfully or not
   */
  public String RegisterMagazine(String id, String name, int pages, String date, int pagesRead, float price,
      String image, String category, int issuanceFrequency, int subscriptions) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i) == null) {
        products.set(i,
            new Magazine(id, name, pages, date, pagesRead, price, image, category, issuanceFrequency, subscriptions));
        return "Magazine registered successfully";
      }
    }
    return "Error: There is no space for more magazines";
  }

  /**
   *
   * This method remove a book in the system.
   * @param bookId id of the book
   * @return a message that indicates if the book was removed successfully or not
   */
  public String RemoveBook(String bookId) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i) instanceof Book) {
        if (products.get(i).getId().equals(bookId)) {
          products.set(i, null);
          return "Book removed successfully";
        }
      }
    }
    return "Error: Book not found";
  }

  /**
   *
   * This method remove a magazine in the system.
   * @param magazineId id of the magazine
   * @return a message that indicates if the magazine was removed successfully or not
   */
  public String RemoveMagazine(String magazineId) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i) instanceof Magazine) {
        if (products.get(i).getId().equals(magazineId)) {
          products.set(i, null);
          return "Magazine removed successfully";
        }
      }
    }
    return "Error: Magazine not found";
  }

  /**
   *
   * This method register a book in the system.
   * @param id         id of the book
   * @param name       name of the book
   * @param pages      number of pages of the book
   * @param date       date of publication of the book
   * @param image      image url of the book
   * @param price      price of the book
   * @param review     review of the book
   * @param pagesRead  number of pages read of the book
   * @param genre      genre of the book
   * @param soldCopies number of sold copies of the book
   * @return a message that indicates if the book was registered successfully or not
   */
  public String RegisterBook(String id, String name, int pages, String date, int pagesRead, float price, String image,
      String review, String genre, int soldCopies) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i) == null) {
        products.set(i, new Book(id, name, pages, date, pagesRead, price, image, review, genre, soldCopies));
        return "Book registered successfully";
      }
    }
    return "Error: There is no space for more books";
  }

  /**
   *
   * This method buy a book by a user.
   * @param userId id of the user
   * @param bookId id of the book
   * @return a message that indicates if the book was bought successfully or not
   */
  public String BuyBook(String userId, String bookId) {
    for (User user : users) {
      if (user.getId().equals(userId)) {
        if (user instanceof RegularUser) {
          if (((RegularUser) user).getBookCount() == 5) {
            return "Error: User has reached the maximum number of books";
          }
        }
        for (Product product : products) {
          if (product instanceof Book) {
            if (product.getId().equals(bookId)) {
              user.setProduct(bookId);
              ((Book) product).setSoldCopies(((Book) product).getSoldCopies() + 1);
              return "Book bought successfully";
            }
          }
        }
        return "Error: Book not found";
      }
    }
    return "Error: User not found";
  }

  /**
   *
   * This method subscribe a magazine by a user.
   * @param userId     id of the user
   * @param magazineId id of the magazine
   * @return a message that indicates if the magazine was subscribed successfully or not
   */
  public String SubscribeMagazine(String userId, String magazineId) {
    for (User user : users) {
      if (user.getId().equals(userId)) {
        if (user instanceof RegularUser) {
          if (((RegularUser) user).getMagazineCount() == 2) {
            return "Error: User has reached the maximum number of magazines";
          }
        }
        for (Product product : products) {
          if (product instanceof Magazine) {
            if (product.getId().equals(magazineId)) {
              user.setProduct(magazineId);
              ((Magazine) product).setSubscriptions(((Magazine) product).getSubscriptions() + 1);
              if (user instanceof RegularUser) {
                ((RegularUser) user).setMagazineCount(((RegularUser) user).getMagazineCount() + 1);
              }
              return "Magazine subscribed successfully";
            }
          }
        }
        return "Error: Magazine not found";
      }
    }
    return "Error: User not found";
  }

  /**
   * 
   * This method modifies the information of a Magazine
   * @param id new id of the magazine
   * @param name new name of the magazine
   * @param pages new number of pages of the magazine
   * @param date new date of publication of the magazine
   * @param category new category of the magazine
   * @param image new image url of the magazine
   * @param price new price of the magazine
   * @param issuanceFrequency new frequency of issuance of the magazine 
   * @param subscriptions new number of subscriptions of the magazine
   * @param pagesRead new number of pages read of the magazine
   * @return a message that indicates if the magazine was modified successfully or not
   */
  public String ModifyMagazine(String id, String name, int pages, String date, String category, String image,
      float price, int issuanceFrequency, int subscriptions, int pagesRead) {
    for (Product product : products) {
      if (product instanceof Magazine) {
        if (product.getId().equals(id)) {
          product.setName(name);
          product.setPages(pages);
          product.setDate(date);
          product.setPrice(price);
          product.setImage(image);
          product.setPagesRead(pagesRead);
          ((Magazine) product).setCategory(category);
          ((Magazine) product).setSubscriptions(subscriptions);
          ((Magazine) product).setIssuanceFrequency(issuanceFrequency);
          ((Magazine) product).setSubscriptions(subscriptions);
          return "Magazine modified successfully";
        }
      }
    }
    return "Error: Magazine not found";
  }

  /**
   * 
   * This method modifies the information of a Book
   * @param id new id of the book
   * @param name new name of the book
   * @param pages new number of pages of the book
   * @param date new date of publication of the book
   * @param image new image url of the book
   * @param price new price of the book
   * @param review new review of the book
   * @param pagesRead new number of pages read of the book
   * @param genre new genre of the book
   * @param soldCopies new number of sold copies of the book
   * @return a message that indicates if the book was modified successfully or not
   */
  public String ModifyBook(String id, String name, int pages, String date, int pagesRead, float price, String image,
      String review, String genre, int soldCopies) {
    for (Product product : products) {
      if (product instanceof Book) {
        if (product.getId().equals(id)) {
          product.setName(name);
          product.setPages(pages);
          product.setDate(date);
          product.setPagesRead(pagesRead);
          product.setPrice(price);
          product.setImage(image);
          ((Book) product).setReview(review);
          ((Book) product).setGenre(genre);
          ((Book) product).setSoldCopies(soldCopies);
          return "Book modified successfully";
        }
      }
    }
    return "Error: Book not found";
  }

  /**
   * 
   * This method return all the products
   * @return an ArrayList with all the products
   */
  public ArrayList<Product> getProducts() {
    return this.products;
  }

  /**
   * 
   * This method return all the users
   * @return an ArrayList with all the users
   */
  public ArrayList<User> getUsers() {
    return this.users;
  }

  /**
   *
   * This method return a product
   * @param productId id of the product
   * @return the product
   */
  public Product getProduct(String productId) {
    for (Product product : products) {
      if (product.getId().equals(productId)) {
        return product;
      }
    }
    return null;
  }

  /**
   * 
   * This method return a book
   * @param bookId id of the book
   * @return the book
   */
  public Book getBook(String bookId) {
    for (Product product : products) {
      if (product instanceof Book) {
        if (product.getId().equals(bookId)) {
          return (Book) product;
        }
      }
    }
    return null;
  }

  /**
   * 
   * This method return a magazine
   * @param magazineId id of the magazine
   * @return the magazine
   */
  public Magazine getMagazine(String magazineId) {
    for (Product product : products) {
      if (product instanceof Magazine) {
        if (product.getId().equals(magazineId)) {
          return (Magazine) product;
        }
      }
    }
    return null;
  }

  /**
   * 
   * This method return user index on the ArrayList
   * @param userId id of the user
   * @return the user index on the ArrayList
   */
  public int getUser(String userId) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getId().equals(userId)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * This method generate the reports
   * @return a string with all the reports
   */
  public String GenerateReport() {
    // TODO - implement ReadXController.GenerateReport
    throw new UnsupportedOperationException();
  }

  /**
   * 
   * This method generates 10 books and 10 magazines and 10 users (5 regular and 5 premium)
   * @return a message that indicates if the test elements were generated successfully or not
   */
  public String GenerateTestElements() {
    for (int i = 0; i < 10; i++) {
      products.add(i, new Book(GenRandomHex(), "Book" + i, 100, "01/01/2000", 0, 10, "image", "review", "FANTASY", 0));
    }
    for (int i = 10; i < 20; i++) {
      products.add(i, new Magazine("Magazine" + i, "Magazine" + i, 100, "01/01/2000", 0, 10, "image", "VARIETY", 0, 0));
    }
    users = Utils.getUsers();
    return "Test elements generated successfully";
  }

  /**
   * 
   * This method generates a random hexadecimal number
   * @return a random hexadecimal number
   */
  public String ShowUsers() {
    StringBuilder result = new StringBuilder();
    for (User user : users) {
      result.append(user.toString()).append("\n");
    }
    return result.toString();
  }

  /**
   * 
   * This method shows all the books
   * @return a string with all the books
   */
  public String ShowBooks() {
    StringBuilder result = new StringBuilder();
    for (Product product : products) {
      if (product instanceof Book) {
        result.append(product.toString()).append("\n");
      }
    }
    return result.toString();
  }

  /**
   * 
   * This method return all the products of the user
   * @param userId id of the user
   * @return a string with all the products of the user
   */
  public String ShowUserProducts(String userId, int page) {
    StringBuilder result = new StringBuilder();
    int userIndex = getUser(userId);
    if (userIndex == -1) {
      return "Error: User not found";
    }

    User user = users.get(userIndex);
    if (user.getProducts().isEmpty()) {
      return "Error: User has no products";
    }

    int start = (page - 1) * 25;
    int end = page * 25;

    if (end > user.getProducts().size()) {
      end = user.getProducts().size();
    }

    for (int i = start; i < end; i++) {
      if (i % 5 == 0) {
        result.append("\n");
      }
      if (user.getProducts().get(i).equals("")) {
        result.append("____").append(" | ");
      } else {
        result.append(user.getProducts().get(i)).append(" | ");
      }
      result.append(user.getProducts().get(i)).append(" | ");
    }
    result.append("\n");
    result.append("Type the x,y coordinate or the corresponding code of the bibliographic product to start a reading session.");
    result.append("\n");
    result.append("Type A to go to the previous page");
    result.append("\n");
    result.append("Type S to go to the next page");
    result.append("\n");
    result.append("Type B to exit");
    return result.toString();
  }

  /**
   * 
   * This methods return if the user can see the ads or not
   * @param userIndex index of the user on the ArrayList
   * @return true if the user can see the ads, false if not
   */
  public boolean Advertisable(int userIndex) {
    return users.get(userIndex) instanceof RegularUser;
  }

  /**
   * 
   * This method return a regular user
   * @param userIndex index of the user on the ArrayList
   * @return the regular user
   */
  public RegularUser getRegularUser(int userIndex) {
    return (RegularUser) users.get(userIndex);
  }

  /**
   * 
   * This method shows all the magazines
   * @return a string with all the magazines
   */
  public String ShowMagazines() {
    StringBuilder result = new StringBuilder();
    for (Product product : products) {
      if (product instanceof Magazine) {
        result.append(product.toString()).append("\n");
      }
    }
    return result.toString();
  }

  /**
   * 
   * This method generates a random hexadecimal number
   * @return a random hexadecimal number
   */
  private String GenRandomHex() {
    Random rand = new Random();
    int randomNumber = rand.nextInt(0xFFF + 1);
    return Integer.toHexString(randomNumber);
  }
}