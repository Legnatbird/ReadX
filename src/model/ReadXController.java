package model;

import java.util.ArrayList;
import utils.Utils;

public class ReadXController {

  private ArrayList<User> users;
  private ArrayList<Product> products;

  public ReadXController() {}

  /**
   *
   * @param name name of the user
   * @param id id of the user
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
   * @param id id of the book
   * @param name name of the book
   * @param pages number of pages of the book
   * @param date date of publication of the book
   * @param price price of the book
   * @param pagesRead number of pages read of the book
   * @param issuanceFrequency frequency of issuance of the book
   * @param subscriptions number of subscriptions of the book
   */
  public String RegisterMagazine(String id, String name, int pages, String date, int pagesRead, float price, String image, String category, int issuanceFrequency, int subscriptions) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i) == null) {
        products.set(i, new Magazine(id, name, pages, date, pagesRead, price, image, category, issuanceFrequency, subscriptions));
        return "Magazine registered successfully";
      }
    }
    return "Error: There is no space for more magazines";
  }

  /**
   *
   * @param bookId id of the book
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
   * @param magazineId id of the magazine
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
   * @param id id of the book
   * @param name name of the book
   * @param pages number of pages of the book
   * @param date date of publication of the book
   * @param image image url of the book
   * @param price price of the book
   * @param review review of the book
   * @param pagesRead number of pages read of the book
   * @param soldCopies number of sold copies of the book
   */
  public String RegisterBook(String id, String name, int pages, String date, int pagesRead, float price, String image, String review, String genre, int soldCopies) {
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
   * @param userId id of the user
   * @param bookId id of the book
   */
  public String BuyBook(String userId, String bookId) {
    String regex = "^[0-9a-fA-F]+$";
    if (!bookId.matches(regex)) {
      return "Error: Invalid id format";
    }
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
              if (user instanceof RegularUser) {
                ((RegularUser) user).setBookCount(((RegularUser) user).getBookCount() + 1);
              }
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
   * @param userId id of the user
   * @param magazineId id of the magazine
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

  public String ModifyMagazine(String id, String name, int pages, String date, String category, String image, float price, int issuanceFrequency, int subscriptions, int pagesRead) {
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

  public String ModifyBook(String id, String name, int pages, String date, int pagesRead, float price, String image, String review, String genre, int soldCopies) {
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

  public ArrayList<Product> GetProducts() {
    return this.products;
  }

  public ArrayList<User> GetUsers() {
    return this.users;
  }

  /**
   *
   * @param productId id of the product
   */
  public Product GetProduct(String productId) {
    // TODO - implement ReadXController.GetProduct
    throw new UnsupportedOperationException();
  }

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

  public User getUser(String userId) {
    for (User user : users) {
      if (user.getId().equals(userId)) {
        return user;
      }
    }
    return null;
  }

  public String GenerateReport() {
    // TODO - implement ReadXController.GenerateReport
    throw new UnsupportedOperationException();
  }

  public String GenerateTestElements() {
    for (int i = 0; i < 10; i++) {
      products.set(i, new Book("Book" + i, "Book" + i, 100, "01/01/2000", 0, 10, "image", "review", "genre", 0));
    }
    for (int i = 10; i < 20; i++) {
      products.set(i, new Magazine("Magazine" + i, "Magazine" + i, 100, "01/01/2000", 0, 10, "image", "category", 0, 0));
    }
    users = Utils.getUsers();
    return "Test elements generated successfully";
  }

  public Book ReadingBook(String bookId, String userId) {
    for (User user : users) {
      if (user.getId().equals(userId)) {
        if (user instanceof RegularUser) {
          ArrayList<String> books = ((RegularUser) user).getProducts();
          for (String book : books) {
            if (book.equals(bookId)) {
              for (Product product : products) {
                if (product.getId().equals(bookId)) {
                  return (Book) product;
                }
              }
            }
          }
        }
      }
    }
    return null;
  }
}