package ui;

import model.ReadXController;
import utils.*;

import static utils.MagazineInfo.getMagazineInfo;
import static utils.BookInfo.getBookInfo;


public class ReadX {

  private static final ReadXController controller = new ReadXController();

  public static void main(String[] args) {
    int option;
    do {
      Utils.print("Welcome to ReadX");
      Menu();
      option = Utils.input.nextInt();
      switch (option) {
        case 1 -> RegisterUser();
        case 2 -> ManageProducts();
        case 3 -> GenerateTestElements();
        case 4 -> BuyBook();
        case 5 -> SubscribeMagazine();
        case 6 -> ReadingSession();
        case 7 -> ShowProducts();
        case 8 -> GenerateReport();
        case 9 -> Utils.print("Bye");
        default -> Utils.print("Invalid option");
      }
    } while (option != 9);
  }

  public static void RegisterUser() {
    Utils.print("Enter name: ");
    String name = Utils.input.nextLine();
    Utils.print("Enter id: ");
    String id = Utils.input.nextLine();
    Utils.print("Premium user? Enter (y/n)");
    boolean type = Utils.input.nextLine().equals("y");
    Utils.print(controller.RegisterUser(name, id, type));
  }

  public static void ManageProducts() {
    Utils.print("1. Manage book");
    Utils.print("2. Manage magazine");
    int option = Utils.input.nextInt();
    switch (option) {
      case 1 -> ManageBook();
      case 2 -> ManageMagazine();
      default -> Utils.print("Invalid option");
    }
  }

  public static void ManageBook() {
    Utils.print("What do you want to do?");
    Utils.print("1. Register book");
    Utils.print("2. Remove book");
    Utils.print("3. Modify book");
    int option = Utils.input.nextInt();
    switch (option) {
      case 1 -> {
        BookInfo info = getBookInfo();
        Utils.print(controller.RegisterBook(info.id(), info.name(), info.pages(), info.date(), info.pagesRead(), info.price(), info.image(), info.review(), info.genre(), info.soldCopies()));
      }
      case 2 -> {
        Utils.print("Enter id: ");
        String id = Utils.input.nextLine();
        Utils.print(controller.RemoveBook(id));
      }
      case 3 -> {
        BookInfo info = getBookInfo();
        Utils.print(controller.ModifyBook(info.id(), info.name(), info.pages(), info.date(), info.pagesRead(), info.price(), info.image(), info.review(), info.genre(), info.soldCopies()));
      }
      default -> Utils.print("Invalid option");
    }
  }

  public static void ManageMagazine() {
    Utils.print("What do you want to do?");
    Utils.print("1. Register magazine");
    Utils.print("2. Remove magazine");
    Utils.print("3. Modify magazine");
    int option = Utils.input.nextInt();
    switch (option) {
      case 1 -> {
        MagazineInfo info = getMagazineInfo();
        Utils.print(controller.RegisterMagazine(info.id(), info.name(), info.pages(), info.date(), info.pagesRead(), info.price(), info.image(), info.category(), info.issuanceFrequency(),
            info.subscriptions()));
      }
      case 2 -> {
        Utils.print("Enter id: ");
        String id = Utils.input.nextLine();
        Utils.print(controller.RemoveMagazine(id));
      }
      case 3 -> {
        MagazineInfo result = getMagazineInfo();
        Utils.print(controller.ModifyMagazine(result.id(), result.name(), result.pages(), result.date(), result.category(), result.image(), result.price(), result.issuanceFrequency(), result.subscriptions(),
            result.pagesRead()));
      }
      default -> Utils.print("Invalid option");
    }
  }

  public static void GenerateTestElements() {
    Utils.print(controller.GenerateTestElements());
  }
  public static void BuyBook() {
    Utils.print("Enter user id: ");
    String id = Utils.input.nextLine();
    Utils.print("Enter book id: ");
    String bookId = Utils.input.nextLine();
    Utils.print(controller.BuyBook(id, bookId));
  }

  public static void SubscribeMagazine() {
    Utils.print("Enter user id: ");
    String id = Utils.input.nextLine();
    Utils.print("Enter magazine id: ");
    String magazineId = Utils.input.nextLine();
    Utils.print(controller.SubscribeMagazine(id, magazineId));
  }

  public static void ReadingSession() {
    Utils.print("Enter user id: ");
    String id = Utils.input.nextLine();
    if (controller.getUser(id) == null) {
      Utils.print("User not found");
      return;
    }
    Utils.print("Enter book id: ");
    String bookId = Utils.input.nextLine();
    if (controller.getBook(bookId) == null) {
      Utils.print("Book not found");
      return;
    }
    int pages = controller.getBook(bookId).getPages();
    int pagesRead = 0;
    do {
      ReadMenu(bookId);
      String option = Utils.input.nextLine();
      switch (option) {
        case "A" -> {
          if (pagesRead < 1) {
            Utils.print("You can't go back");
            break;
          }
          pagesRead--;
        }
        case "S" -> {
          if (pagesRead == pages) {
            Utils.print("You can't go forward");
            break;
          }
          pagesRead++;
        }
        case "B" -> {
          Utils.print("Reading session finished");
          controller.getBook(bookId).setPagesRead(pagesRead);
          return;
        }
      }
    } while (true);
  }

  public static void ShowProducts() {
    // TODO - implement ReadX.ShowProducts
    throw new UnsupportedOperationException();
  }

  public static void GenerateReport() {
    // TODO - implement ReadX.GenerateReport
    throw new UnsupportedOperationException();
  }

  public static void Menu() {
    Utils.print("1. Register User");
    Utils.print("2. Manage Products");
    Utils.print("3. Generate test elements");
    Utils.print("4. Buy a book");
    Utils.print("5. Subscribe to a magazine");
    Utils.print("6. Read a book");
    Utils.print("7. Show products");
    Utils.print("8. Generate reports");
    Utils.print("9. Exit");
  }

  public static void ReadMenu(String bookId) {
    Utils.print("Reading session in progress:");
    Utils.print("Reading: " + controller.getBook(bookId).getName());
    Utils.print("Reading page " + controller.getBook(bookId).getPagesRead() + " of " + controller.getBook(bookId).getPages());
    Utils.print("Type A to go to the previous page");
    Utils.print("Type S to go to the next page");
    Utils.print("Type B to return to the library");
  }
}