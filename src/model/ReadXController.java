package model;

public class ReadXController {

	private User[] users;
	private Product[] products;

	public ReadXController() {
		// TODO - implement ReadXController.ReadXController
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param id
	 */
	public String RegisterUser(String name, String id, boolean type) {
		for (int i = 0; i < users.length; i++) {
			if (users[i] == null) {
				if (type) users[i] = new PremiumUser(name, id);
				else users[i] = new RegularUser(name, id);
				return "User registered successfully";
			}
		}
		return "Error: There is no space for more users";
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param pages
	 * @param date
	 * @param price
	 * @param issuance_frequency
	 * @param subscription
	 * @param pages_readed
	 * @param issuanceFrecuency
	 * @param subscriptions
	 */
	public String RegisterMagazine(String id, String name, int pages, String date, float price, String image, String subscription, int pages_readed, int issuanceFrecuency, int subscriptions) {
		// TODO - implement ReadXController.RegisterMagazine
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bookId
	 */
	public String RemoveBook(String bookId) {
		// TODO - implement ReadXController.RemoveBook
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param magazineId
	 */
	public String RemoveMagazine(String magazineId) {
		// TODO - implement ReadXController.RemoveMagazine
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param pages
	 * @param date
	 * @param image
	 * @param price
	 * @param sold_units
	 * @param review
	 * @param pages_readed
	 * @param soldCopies
	 */
	public String RegisterBook(String id, String name, int pages, String date, String image, float price, String review, int pages_readed, int soldCopies) {
		// TODO - implement ReadXController.RegisterBook
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param bookId
	 */
	public String BuyBook(String userId, String bookId) {
		// TODO - implement ReadXController.BuyBook
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param magazineId
	 */
	public String SubscribeMagazine(String userId, String magazineId) {
		// TODO - implement ReadXController.SubscribeMagazine
		throw new UnsupportedOperationException();
	}

	public Product[] GetProducts() {
		return this.products;
	}

	public User[] GetUsers() {
		return this.users;
	}

	/**
	 * 
	 * @param productId
	 */
	public Product GetProduct(String productId) {
		// TODO - implement ReadXController.GetProduct
		throw new UnsupportedOperationException();
	}

	public String GenerateReport() {
		// TODO - implement ReadXController.GenerateReport
		throw new UnsupportedOperationException();
	}

	public String GenerateTestElements() {
		// TODO - implement ReadXController.GenerateTestElements
		throw new UnsupportedOperationException();
	}
}