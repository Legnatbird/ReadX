package ui;

import model.ReadXController;
import java.util.Scanner;

public class ReadX {

  private static final ReadXController controller = new ReadXController();
  public static final Scanner input = new Scanner(System.in);

  public static void print(Object uwu) {
    System.out.println(uwu);
  }

  public static void main(String[] args) {
    int option;
    do {
      print("Welcome to ReadX");
      Menu();
      option = input.nextInt();
      switch (option) {
        case 1 -> RegisterUser();
        case 2 -> ManageProducts();
        case 3 -> GenerateTestElements();
        case 4 -> BuyBook();
        case 5 -> SubscribeMagazine();
        case 6 -> ReadingSession();
        case 7 -> ShowProducts();
        case 8 -> ShowUsers();
        case 9 -> GenerateReport();
        case 10 -> print("Bye");
        default -> print("Invalid option");
      }
    } while (option != 10);
  }

  public static void RegisterUser() {
    print("Enter name: ");
    input.nextLine();
    String name = input.nextLine();
    print("Enter id: ");
    String id = input.nextLine();
    print("Premium user? Enter (y/n)");
    boolean type = input.nextLine().equals("y");
    print(controller.RegisterUser(name, id, type));
  }

  public static void ManageProducts() {
    print("1. Manage book");
    print("2. Manage magazine");
    int option = input.nextInt();
    switch (option) {
      case 1 -> ManageBook();
      case 2 -> ManageMagazine();
      default -> print("Invalid option");
    }
  }

  public static void ManageBook() {
    print("What do you want to do?");
    print("1. Register book");
    print("2. Remove book");
    print("3. Modify book");
    int option = input.nextInt();
    switch (option) {
      case 1 -> {
        String id, name, date;
        print("Enter id: ");
        id = ValidateProductId();
        print("Enter name: ");
        name = input.nextLine();
        print("Enter number of pages: ");
        int pages = input.nextInt();
        print("Enter date: ");
        date = input.nextLine();
        print("Enter number of pages read: ");
        int pagesRead = input.nextInt();
        print("Enter price: ");
        float price = input.nextFloat();
        print("Enter image url: ");
        String image = input.nextLine();
        print("Enter review: ");
        String review = input.nextLine();
        print("Enter genre: ");
        String genre = input.nextLine();
        print("Enter sold copies: ");
        int soldCopies = input.nextInt();
        print(controller.RegisterBook(id, name, pages, date, pagesRead, price, image, review, genre, soldCopies));
      }
      case 2 -> {
        print("Enter id: ");
        String id = input.nextLine();
        print(controller.RemoveBook(id));
      }
      case 3 -> {
        String id, name, date;
        int pages, pagesRead, soldCopies;
        float price;
        print("Enter id: ");
        id = ValidateProductId();
        print("Enter name: ");
        name = input.nextLine();
        print("Enter number of pages: ");
        pages = input.nextInt();
        print("Enter date: ");
        date = input.nextLine();
        print("Enter number of pages read: ");
        pagesRead = input.nextInt();
        print("Enter price: ");
        price = input.nextFloat();
        print("Enter image url: ");
        String image = input.nextLine();
        print("Enter review: ");
        String review = input.nextLine();
        print("Enter genre: ");
        String genre = input.nextLine();
        print("Enter sold copies: ");
        soldCopies = input.nextInt();
        print(controller.ModifyBook(id, name, pages, date, pagesRead, price, image, review, genre, soldCopies));
      }
      default -> print("Invalid option");
    }
  }

  public static void ManageMagazine() {
    print("What do you want to do?");
    print("1. Register magazine");
    print("2. Remove magazine");
    print("3. Modify magazine");
    int option = input.nextInt();
    switch (option) {
      case 1 -> {
        String id, name, date, category, image;
        int pages, issuanceFrequency, subscriptions, pagesRead;
        float price;
        print("Enter id: ");
        id = input.nextLine();
        print("Enter name: ");
        name = input.nextLine();
        print("Enter number of pages: ");
        pages = input.nextInt();
        print("Enter date: ");
        date = input.nextLine();
        print("Enter price: ");
        price = input.nextFloat();
        print("Enter category: ");
        category = input.nextLine();
        print("Enter image: ");
        image = input.nextLine();
        print("Enter Issuance frequency: ");
        issuanceFrequency = input.nextInt();
        print("Enter subscriptions: ");
        subscriptions = input.nextInt();
        print("Enter pages read: ");
        pagesRead = input.nextInt();
        print(controller.RegisterMagazine(id, name, pages, date, pagesRead, price, image, category, issuanceFrequency,
            subscriptions));
      }
      case 2 -> {
        print("Enter id: ");
        String id = input.nextLine();
        print(controller.RemoveMagazine(id));
      }
      case 3 -> {
        String id, name, date, category, image;
        int pages, issuanceFrequency, subscriptions, pagesRead;
        float price;
        print("Enter id: ");
        id = input.nextLine();
        print("Enter name: ");
        name = input.nextLine();
        print("Enter number of pages: ");
        pages = input.nextInt();
        print("Enter date: ");
        date = input.nextLine();
        print("Enter price: ");
        price = input.nextFloat();
        print("Enter category: ");
        category = input.nextLine();
        print("Enter image: ");
        image = input.nextLine();
        print("Enter Issuance frequency: ");
        issuanceFrequency = input.nextInt();
        print("Enter subscriptions: ");
        subscriptions = input.nextInt();
        print("Enter pages read: ");
        pagesRead = input.nextInt();
        print(controller.ModifyMagazine(id, name, pages, date, category, image, price, issuanceFrequency, subscriptions,
            pagesRead));
      }
      default -> print("Invalid option");
    }
  }

  public static void GenerateTestElements() {
    print(controller.GenerateTestElements());
  }

  public static void BuyBook() {
    print("Enter user id: ");
    input.nextLine();
    String userId = input.nextLine();
    print("Enter book id: ");
    String bookId = ValidateProductId();
    print(controller.BuyBook(userId, bookId));
  }

  public static void SubscribeMagazine() {
    print("Enter user id: ");
    input.nextLine();
    String id = input.nextLine();
    print("Enter magazine id: ");
    String magazineId = input.nextLine();
    print(controller.SubscribeMagazine(id, magazineId));
  }

  public static void ReadingSession() {
    String id, productId, name;
    int pages, pagesRead;
    print("Enter user id: ");
    input.nextLine();
    id = input.nextLine();
    if (controller.getUser(id) == null) {
      print("User not found");
      return;
    }
    print("Enter book or magazine id: ");
    productId = ValidateProductId();
    if (controller.getProduct(productId) == null) {
      print("Product not found");
      return;
    }
    name = controller.getProduct(productId).getName();
    pages = controller.getProduct(productId).getPages();
    pagesRead = 0;
    do {
      ReadMenu(name, pages, pagesRead);
      String option = input.nextLine().toUpperCase();
      switch (option) {
        case "A" -> {
          if (pagesRead < 1) {
            print("You can't go back");
            break;
          }
          pagesRead--;
        }
        case "S" -> {
          if (pagesRead == pages) {
            print("You can't go forward");
            break;
          }
          pagesRead++;
        }
        case "B" -> {
          print("Reading session finished");
          controller.getBook(productId).setPagesRead(pagesRead);
          return;
        }
      }
    } while (true);
  }

  public static void ShowProducts() {
    print("1. Show books");
    print("2. Show magazines");
    int option = input.nextInt();
    switch (option) {
      case 1 -> print(controller.ShowBooks());
      case 2 -> print(controller.ShowMagazines());
      default -> print("Invalid option");
    }
  }

  public static void GenerateReport() {
    // TODO - implement ReadX.GenerateReport
    throw new UnsupportedOperationException();
  }

  public static void Menu() {
    print("1. Register User");
    print("2. Manage Products");
    print("3. Generate test elements");
    print("4. Buy a book");
    print("5. Subscribe to a magazine");
    print("6. Read a product");
    print("7. Show products");
    print("8. Show user");
    print("9. Generate reports");
    print("10. Exit");
  }

  public static void ShowUsers() {
    print(controller.ShowUsers());
  }

  public static void ReadMenu(String bookName, int pages, int pagesRead) {
    print("Reading session in progress:");
    print("Reading: " + bookName);
    print("Reading page " + pagesRead + " of " + pages);
    print("Type A to go to the previous page");
    print("Type S to go to the next page");
    print("Type B to return to the library");
  }

  public static String ValidateProductId() {
    String regex = "^[0-9a-fA-F]+$";
    String bookId = input.nextLine();
    if (!bookId.matches(regex)) {
      print("Invalid id, remember that it must be a hexadecimal");
      return ValidateProductId();
    }
    return bookId;
  }

}