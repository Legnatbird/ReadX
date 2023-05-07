package utils;

import ui.ReadX;

import static utils.BasicInfo.getBasicInfo;

public record BookInfo(String id, String name, String date, String image, String review, String genre, int pages, int pagesRead, int soldCopies, float price) {
  public static BookInfo getBookInfo() {
    String genre, review, image;
    int pagesRead, soldCopies;
    BasicInfo basicInfo = getBasicInfo();
    Utils.print("Enter pages read: ");
    pagesRead = Utils.input.nextInt();
    Utils.print("Enter image: ");
    image = Utils.input.nextLine();
    Utils.print("Enter review: ");
    review = Utils.input.nextLine();
    Utils.print("Enter genre: ");
    genre = Utils.input.nextLine();
    Utils.print("Enter sold copies: ");
    soldCopies = Utils.input.nextInt();
    return new BookInfo(basicInfo.id(), basicInfo.name(), basicInfo.date(), image, review, genre, basicInfo.pages(), pagesRead, soldCopies, basicInfo.price());
  }
}