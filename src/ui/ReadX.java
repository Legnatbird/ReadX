package ui;

import model.ReadXController;

import java.util.Scanner;

public class ReadX {

	private static ReadXController controller;
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int option = 0;
		do {
			System.out.println("Welcome to ReadX");
			Menu();
			option = input.nextInt();
			switch (option) {
				case 1:
					RegisterUser();
					break;
				case 2:
					ManageProducts();
					break;
				case 3:
					GenerateTestElements();
					break;
				case 4:
					BuyBook();
					break;
				case 5:
					SubscribeMagazine();
					break;
				case 6:
					ReadingSession();
					break;
				case 7:
					ShowProducts();
					break;
				case 8:
					GenerateReport();
					break;
				case 9:
					print("Bye");
					break;
				default:
					print("Invalid option");
					break;
			}
		} while (option != 8);
	}

	public static void RegisterUser() {
		print("Enter name: ");
		String name = input.nextLine();
		print("Enter id: ");
		String id = input.nextLine();
		print("Premium user? Enter (y/n)");
		boolean type = input.nextLine().equals("y");
		controller.RegisterUser(name, id, type);
	}

	public static void ManageProducts() {
		print("1. Manage book");
		print("2. Manage magazine");
		int option = input.nextInt();
		switch (option) {
			case 1:
				ManageBook();
				break;
			case 2:
				ManageMagazine();
				break;
			default:
				print("Invalid option");
				break;
		}
	}

	public static void ManageBook() {
		print("What do you want to do?");
		print("1. Register book");
		print("2. Remove book");
		print("3. Modify book");
		int option = input.nextInt();
		String id, name, date, image, review, genre;
		int pages, pagesReaded, soldCopies;
		float price;
		switch (option) {
			case 1:
				print("Enter id: ");
				id = input.nextLine();
				print("Enter name: ");
				name = input.nextLine();
				print("Enter pages: ");
				pages = input.nextInt();
				print("Enter date: ");
				date = input.nextLine();
				print("Enter pages readed: ");
				pagesReaded = input.nextInt();
				print("Enter price: ");
				price = input.nextFloat();
				print("Enter image: ");
				image = input.nextLine();
				print("Enter review: ");
				review = input.nextLine();
				print("Enter genre: ");
				genre = input.nextLine();
				print("Enter sold copies: ");
				soldCopies = input.nextInt();
				print(controller.RegisterBook(id, name, pages, date, pagesReaded, price, image, review, genre, soldCopies));
				break;
			case 2:
				print("Enter id: ");
				id = input.nextLine();
				print(controller.RemoveBook(id));
				break;
			case 3:
				print("Enter id: ");
				id = input.nextLine();
				print("Enter name: ");
				name = input.nextLine();
				print("Enter pages: ");
				pages = input.nextInt();
				print("Enter date: ");
				date = input.nextLine();
				print("Enter pages readed: ");
				pagesReaded = input.nextInt();
				print("Enter price: ");
				price = input.nextFloat();
				print("Enter image: ");
				image = input.nextLine();
				print("Enter review: ");
				review = input.nextLine();
				print("Enter genre: ");
				genre = input.nextLine();
				print("Enter sold copies: ");
				soldCopies = input.nextInt();
				controller.ModifyBook(id, name, pages, date, pagesReaded, price, image, review, genre, soldCopies);
				break;
			default:
				print("Invalid option");
				break;
		}
	}

	public static void ManageMagazine() {
		print("What do you want to do?");
		print("1. Register magazine");
		print("2. Remove magazine");
		print("3. Modify magazine");
		int option = input.nextInt();
		String id, name, date, image, category;
		int pages, pagesReaded, issuanceFrequency, subscriptions;
		float price;
		switch (option) {
			case 1:
				print("Enter id: ");
				id = input.nextLine();
				print("Enter name: ");
				name = input.nextLine();
				print("Enter pages: ");
				pages = input.nextInt();
				print("Enter date: ");
				date = input.nextLine();
				print("Enter category: ");
				category = input.nextLine();
				print("Enter image: ");
				image = input.nextLine();
				print("Enter price: ");
				price = input.nextFloat();
				print("Enter Issuance frequency: ");
				issuanceFrequency = input.nextInt();
				print("Enter subscriptions: ");
				subscriptions = input.nextInt();
				print("Enter pages readed: ");
				pagesReaded = input.nextInt();
				controller.RegisterMagazine(id, name, pages, date, pagesReaded, price, image, category, issuanceFrequency,
						subscriptions);
				break;
			case 2:
				print("Enter id: ");
				id = input.nextLine();
				controller.RemoveMagazine(id);
				break;
			case 3:
				print("Enter id: ");
				id = input.nextLine();
				print("Enter name: ");
				name = input.nextLine();
				print("Enter pages: ");
				pages = input.nextInt();
				print("Enter date: ");
				date = input.nextLine();
				print("Enter category: ");
				category = input.nextLine();
				print("Enter image: ");
				image = input.nextLine();
				print("Enter price: ");
				price = input.nextFloat();
				print("Enter Issuance frequency: ");
				issuanceFrequency = input.nextInt();
				print("Enter subscriptions: ");
				subscriptions = input.nextInt();
				print("Enter pages readed: ");
				pagesReaded = input.nextInt();
				controller.ModifyMagazine(id, name, pages, date, category, image, price, issuanceFrequency, subscriptions,
						pagesReaded);
				break;
			default:
				print("Invalid option");
				break;
		}
	}

	public static void GenerateTestElements() {
		// TODO - implement ReadX.GenerateTestElements
		throw new UnsupportedOperationException();
	}
	public static void BuyBook() {
		// TODO - implement ReadX.BuyBook
		throw new UnsupportedOperationException();
	}

	public static void SubscribeMagazine() {
		// TODO - implement ReadX.SubscribeMagazine
		throw new UnsupportedOperationException();
	}

	public static void ReadingSession() {
		// TODO - implement ReadX.ReadingSession
		throw new UnsupportedOperationException();
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
		print("1. Register User");
		print("2. Manage Products");
		print("3. Generate test elements");
		print("4. Buy a book");
		print("5. Subscribe to a magazine");
		print("6. Read a book");
		print("7. Show products");
		print("8. Generate reports");
		print("9. Exit");
	}

	public static void print(Object uwu) {
		System.out.println(uwu);
	}

}