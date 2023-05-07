package utils;

public record BasicInfo(int pages, String date, String name, String id, float price) {
  public static BasicInfo getBasicInfo() {
    String id, name, date;
    int pages;
    float price;
    Utils.print("Enter id: ");
    id = Utils.input.nextLine();
    Utils.print("Enter name: ");
    name = Utils.input.nextLine();
    Utils.print("Enter pages: ");
    pages = Utils.input.nextInt();
    Utils.print("Enter date: ");
    date = Utils.input.nextLine();
    Utils.print("Enter price: ");
    price = Utils.input.nextFloat();
    return new BasicInfo(pages, date, name, id, price);
  }
}
