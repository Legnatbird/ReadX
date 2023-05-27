package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Random;
import utils.Utils;

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
   * 
   * @param name name of the user
   * @param id   id of the user
   * @param type type of the user
   * @return a message that indicates if the user was registered successfully or
   *         not
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
   * 
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
   * @return a message that indicates if the magazine was registered successfully
   *         or not
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
   * 
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
   * 
   * @param magazineId id of the magazine
   * @return a message that indicates if the magazine was removed successfully or
   *         not
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
   * 
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
   * @return a message that indicates if the book was registered successfully or
   *         not
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
   * 
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
   * 
   * @param userId     id of the user
   * @param magazineId id of the magazine
   * @return a message that indicates if the magazine was subscribed successfully
   *         or not
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
   * 
   * @param id                new id of the magazine
   * @param name              new name of the magazine
   * @param pages             new number of pages of the magazine
   * @param date              new date of publication of the magazine
   * @param category          new category of the magazine
   * @param image             new image url of the magazine
   * @param price             new price of the magazine
   * @param issuanceFrequency new frequency of issuance of the magazine
   * @param subscriptions     new number of subscriptions of the magazine
   * @param pagesRead         new number of pages read of the magazine
   * @return a message that indicates if the magazine was modified successfully or
   *         not
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
   * 
   * @param id         new id of the book
   * @param name       new name of the book
   * @param pages      new number of pages of the book
   * @param date       new date of publication of the book
   * @param image      new image url of the book
   * @param price      new price of the book
   * @param review     new review of the book
   * @param pagesRead  new number of pages read of the book
   * @param genre      new genre of the book
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
          ((Book) product).setGender(genre);
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
   * 
   * @return an ArrayList with all the products
   */
  public ArrayList<Product> getProducts() {
    return this.products;
  }

  /**
   * 
   * This method return all the users
   * 
   * @return an ArrayList with all the users
   */
  public ArrayList<User> getUsers() {
    return this.users;
  }

  /**
   *
   * This method return a product
   * 
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
   * 
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
   * 
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
   * 
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
   * 
   * This method return a user by its index on the ArrayList
   * 
   * @param userIndex
   * @return the user
   */
  public User getUser(int userIndex) {
    return users.get(userIndex);
  }

  /**
   * 
   * This method return a regular user by index on the ArrayList
   * 
   * @param index index of the user on the ArrayList
   * @return the regular user
   */
  public RegularUser getRegularUser(int index) {
    if (users.get(index) instanceof RegularUser) {
      return (RegularUser) users.get(index);
    }
    return null;
  }

  /**
   * 
   * This method generates 10 books and 10 magazines and 10 users (5 regular and 5
   * premium)
   * 
   * @return a message that indicates if the test elements were generated
   *         successfully or not
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
   * 
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
   * 
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
   * 
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

    ArrayList<String> products = user.getProducts();
    int start = (page - 1) * 25;
    int end = page * 25;
    int productSize = user.getProducts().size();

    if (end > productSize) {
      end = productSize;
    }

    for (int i = start; i < end; i++) {
      if (i % 5 == 0) {
        result.append("\n");
      }
      if (user.getProducts().get(i).equals("")) {
        result.append("____").append(" | ");
      } else {
        result.append(products.get(i)).append(" | ");
      }
      result.append(products.get(i)).append(" | ");
    }
    result.append("\n");
    result.append(
        "Type the x,y coordinate or the corresponding code of the bibliographic product to start a reading session.");
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
   * 
   * @param userIndex index of the user on the ArrayList
   * @return true if the user can see the ads, false if not
   */
  public boolean Advertisable(int userIndex) {
    return users.get(userIndex) instanceof RegularUser;
  }

  /**
   * 
   * This method shows all the magazines
   * 
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
   * This method order the products by its date
   * 
   * @return arraylist with the products ordered by date
   */
  public ArrayList<String> OrderByDate(String userId) {

    int userIndex = getUser(userId);
    User user = users.get(userIndex);
    ArrayList<Product> userProducts = new ArrayList<>();
    for (String productId : user.getProducts()) {
      userProducts.add(getProduct(productId));
    }
    Collections.sort(userProducts, new Comparator<Product>() {
      @Override
      public int compare(Product o1, Product o2) {
        return o1.getDate().compareTo(o2.getDate());
      }
    });

    ArrayList<String> userProductsId = new ArrayList<>();
    for (Product product : userProducts) {
      userProductsId.add(product.getId());
    }
    return userProductsId;
  }

  /**
   * 
   * This method create a String with the most readed product
   * 
   * @return a string with all the products ordered by most readed
   */
  public String MostReadedReport() {
    StringBuilder result = new StringBuilder();
    ArrayList<Product> productsPagesRead = OrderByPagesRead();

    for (Product products : productsPagesRead) {
      if (products instanceof Book) {
        result.append(products.toString()).append("\n");
        break;
      }
      if (products instanceof Magazine) {
        result.append(products.toString()).append("\n");
        break;
      }
    }
    return result.toString();
  }

  /**
   * 
   * This method order the products by its pages read
   * 
   * @return ArrayList with the products ordered by its pages read
   */
  private ArrayList<Product> OrderByPagesRead() {
    ArrayList<Product> productsCopy = new ArrayList<>(products);
    Collections.sort(products, new Comparator<Product>() {
      @Override
      public int compare(Product p1, Product p2) {
        return p2.getPagesRead() - p1.getPagesRead();
      }
    });
    return productsCopy;
  }

  /**
   * 
   * This method calculates the number of pages read
   * 
   * @return a string with the number of pages read for each product (book or
   *         magazine) with the name
   */
  public String SummaryOfReadPages() {
    StringBuilder result = new StringBuilder();
    ArrayList<Integer> pagesRead = new ArrayList<>(2);
    for (Product product : products) {
      if (product instanceof Book) {
        pagesRead.set(0, product.getPagesRead() + pagesRead.get(0));
      }
      if (product instanceof Magazine) {
        pagesRead.set(1, product.getPagesRead() + pagesRead.get(1));
      }
    }
    result.append("Books: ").append(pagesRead.get(0)).append("\n");
    result.append("Magazines: ").append(pagesRead.get(1)).append("\n");
    return result.toString();
  }

  /**
   * 
   * This method create a String with the genders of book most read and the
   * categorys of magazine most readed
   * 
   * @return String with the gender/category most readed
   */
  public String BestGenderAndCategoryRead() {
    StringBuilder result = new StringBuilder();

    ArrayList<Product> productsPagesRead = OrderByPagesRead();
    ArrayList<Integer> genders = new ArrayList<>(3);
    ArrayList<Integer> categories = new ArrayList<>(3);

    for (Product product : productsPagesRead) {
      if (product instanceof Book) {
        switch (((Book) product).getGender()) {
          case "SCIENCE_FICTION" -> genders.set(0, product.getPagesRead() + genders.get(0));
          case "FANTASY" -> genders.set(1, product.getPagesRead() + genders.get(1));
          case "HISTORICAL" -> genders.set(2, product.getPagesRead() + genders.get(0));
        }
      }
      if (product instanceof Magazine) {
        switch (((Magazine) product).getCategory()) {
          case "VARIETY" -> categories.set(0, product.getPagesRead() + categories.get(0));
          case "DESIGN" -> categories.set(1, product.getPagesRead() + categories.get(1));
          case "SCIENTIFIC" -> categories.set(2, product.getPagesRead() + categories.get(2));
        }
      }
    }

    int mostReadedGender = Collections.max(genders);
    int mostReadedCategory = Collections.max(categories);

    result.append("The most readed genre is: " + GetGender(genders.indexOf(mostReadedGender)) + "with: "
        + mostReadedGender + " pages readed\n");
    result.append("The most readed category is: " + GetCategory(categories.indexOf(mostReadedCategory)) + "with: "
        + mostReadedCategory + " pages readed\n");

    return result.toString();
  }

  /**
   * 
   * This method create a String with the top 5 books and magazines readed
   * 
   * @return String with the top
   */
  public String Top5GenderAndCategoryRead() {
    StringBuilder bookTop = new StringBuilder();
    StringBuilder magazineTop = new StringBuilder();

    ArrayList<Product> productsPagesRead = OrderByPagesRead();

    int i = 0;
    int k = 0;

    for (Product product : productsPagesRead) {
      if (i == 5) {
        break;
      }
      if (product instanceof Book) {
        bookTop.append(product.toString()).append("\n");
        i++;
      }
    }

    for (Product product : productsPagesRead) {
      if (k == 5) {
        break;
      }
      if (product instanceof Magazine) {
        magazineTop.append(product.toString()).append("\n");
        k++;
      }
    }

    return "Top 5 Books:\n" + bookTop.toString() + "\nTop 5 Magazines:\n" + magazineTop.toString();
  }

  /**
   * 
   * This method create a String with for each gender the number of sold copies
   * 
   * @return String with the genders and the number of sold copies
   */
  public String SoldBooksByGender() {

    StringBuilder result = new StringBuilder();
    ArrayList<Float> booksSold = new ArrayList<>(3);
    ArrayList<Float> totalValue = new ArrayList<>(3);

    for (Product product : products) {
      String gender = ((Book) product).getGender();
      if (gender.equals("SCIENCE_FICTION")) {
        booksSold.set(0, ((Book) product).getSoldCopies() + .0f);
        totalValue.set(0, totalValue.get(0) + ((Book) product).getPrice());
      }
      if (gender.equals("FANTASY")) {
        booksSold.set(1, ((Book) product).getSoldCopies() + .0f);
        totalValue.set(1, totalValue.get(1) + ((Book) product).getPrice());
      }
      if (gender.equals("HISTORICAL")) {
        booksSold.set(2, ((Book) product).getSoldCopies() + .0f);
        totalValue.set(2, totalValue.get(2) + ((Book) product).getPrice());
      }
    }

    result.append("SCIENCE FICTION: ").append(booksSold.get(0)).append(" copies sold, total value: ")
        .append(totalValue.get(0)).append("\n");
    result.append("FANTASY: ").append(booksSold.get(1)).append(" copies sold, total value: ")
        .append(totalValue.get(1)).append("\n");
    result.append("HISTORICAL: ").append(booksSold.get(2)).append(" copies sold, total value: ")
        .append(totalValue.get(2)).append("\n");

    return result.toString();
  }

  /**
   * 
   * This method create a String with for each category the number of subs
   * 
   * @return String with the genders and the number of sold copies
   */
  public String ActiveSubsByCategory() {

    StringBuilder result = new StringBuilder();
    ArrayList<Float> magazineSubs = new ArrayList<>(3);
    ArrayList<Float> totalValue = new ArrayList<>(3);

    for (Product product : products) {
      String category = ((Magazine) product).getCategory();
      if (category.equals("VARIETY")) {
        magazineSubs.set(0, ((Magazine) product).getSubscriptions() + .0f);
        totalValue.set(0, totalValue.get(0) + ((Magazine) product).getPrice());
      }
      if (category.equals("DESIGN")) {
        magazineSubs.set(1, ((Magazine) product).getSubscriptions() + .0f);
        totalValue.set(1, totalValue.get(1) + ((Magazine) product).getPrice());
      }
      if (category.equals("SCIENTIFIC")) {
        magazineSubs.set(2, ((Magazine) product).getSubscriptions() + .0f);
        totalValue.set(2, totalValue.get(2) + ((Magazine) product).getPrice());
      }
    }

    result.append("VARIETY: ").append(magazineSubs.get(0)).append(" active subs, total value: ")
        .append(totalValue.get(0)).append("\n");
    result.append("DESIGN: ").append(magazineSubs.get(1)).append(" active subs, total value: ")
        .append(totalValue.get(1)).append("\n");
    result.append("SCIENTIFIC: ").append(magazineSubs.get(2)).append(" active subs, total value: ")
        .append(totalValue.get(2)).append("\n");

    return result.toString();
  }

  /**
   * 
   * This method generates a random hexadecimal number
   * 
   * @return a random hexadecimal number
   */
  private String GenRandomHex() {
    Random rand = new Random();
    int randomNumber = rand.nextInt(0xFFF + 1);
    return Integer.toHexString(randomNumber);
  }

  /**
   * 
   * This method get the name of the gender with a index
   * 
   * @param genderIndex index on the arraylist of genders
   * @return gender
   */
  private String GetGender(int genderIndex) {
    String gender = "";
    switch (genderIndex) {
      case 1 -> gender = "SCIENCE_FICTION";
      case 2 -> gender = "FANTASY";
      case 3 -> gender = "HISTORICAL";
    }
    return gender;
  }

  /**
   * 
   * This method get the name of the category with a index
   * 
   * @param categoryIndex index on the arraylist of categories
   * @return category
   */
  private String GetCategory(int categoryIndex) {
    String category = "";
    switch (categoryIndex) {
      case 1 -> category = "VARIETY";
      case 2 -> category = "DESIGN";
      case 3 -> category = "SCIENTIFIC";
    }
    return category;
  }
}