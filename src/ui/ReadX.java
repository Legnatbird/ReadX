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
					ManageBook();
					break;
				case 3:
					ManageMagazine();
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
					GenerateTestElements();
					break;
				case 9:
					print("Bye");
					break;
				default:
					print("Invalid option");
					break;
			}
		} while(option != 9);
	}

	public static void RegisterUser() {
		print("Enter your name: ");
		String name = input.nextLine();
		print("Enter your id: ");
		String id = input.nextLine();
		print("You are premium enter (y/n)");
		boolean type = input.nextLine().equals("y");
		controller.RegisterUser(name, id, type);
	}

	public static void ManageBook() {
		// TODO - implement ReadX.ManageBook
		throw new UnsupportedOperationException();
	}

	public static void ManageMagazine() {
		// TODO - implement ReadX.ManageMagazine
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

	public static void ShowProducts() {
		// TODO - implement ReadX.ShowProducts
		throw new UnsupportedOperationException();
	}

	public static void ReadingSession() {
		// TODO - implement ReadX.ReadingSession
		throw new UnsupportedOperationException();
	}

	public static void GenerateTestElements() {
		// TODO - implement ReadX.GenerateTestElements
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