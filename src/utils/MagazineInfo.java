package utils;

import static utils.BasicInfo.getBasicInfo;

public record MagazineInfo(String id, String name, String date, String image, String category, int pages, int pagesRead, int issuanceFrequency, int subscriptions, float price) {

  public static MagazineInfo getMagazineInfo() {
    int subscriptions, pagesRead, issuanceFrequency;
    String category, image;
    BasicInfo basicInfo = getBasicInfo();
    Utils.print("Enter category: ");
    category = Utils.input.nextLine();
   Utils.print("Enter image: ");
    image = Utils.input.nextLine();
    Utils.print("Enter Issuance frequency: ");
    issuanceFrequency = Utils.input.nextInt();
    Utils.print("Enter subscriptions: ");
    subscriptions = Utils.input.nextInt();
    Utils.print("Enter pages read: ");
    pagesRead = Utils.input.nextInt();
    return new MagazineInfo(basicInfo.id(), basicInfo.name(), basicInfo.date(), image, category, basicInfo.pages(), pagesRead, issuanceFrequency, subscriptions, basicInfo.price());
  }
}