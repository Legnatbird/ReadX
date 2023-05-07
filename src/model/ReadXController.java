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
	 * @param pagesRead
	 * @param issuanceFrecuency
	 * @param subscriptions
	 */
	public String RegisterMagazine(String id, String name, int pages, String date, int pagesRead, float price, String image, String category, int issuanceFrequency, int subscriptions) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] == null) {
				products[i] = new Magazine(id, name, pages, date, pagesRead, price, image, category, issuanceFrequency, subscriptions);
				return "Magazine registered successfully";
			}
		}
		return "Error: There is no space for more magazines";
	}

	/**
	 * 
	 * @param bookId
	 */
	public String RemoveBook(String bookId) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] instanceof Book) {
				if (products[i].getId().equals(bookId)) {
					products[i] = null;
					return "Book removed successfully";
				}
			}
		}
		return "Error: Book not found";
	}

	/**
	 * 
	 * @param magazineId
	 */
	public String RemoveMagazine(String magazineId) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] instanceof Magazine) {
				if (products[i].getId().equals(magazineId)) {
					products[i] = null;
					return "Magazine removed successfully";
				}
			}
		}
		return "Error: Magazine not found";
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
	public String RegisterBook(String id, String name, int pages, String date, int pagesReaded, float price, String image, String review, String genre, int soldCopies) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] == null) {
				products[i] = new Book(id, name, pages, date, pagesReaded, price, image, review, genre, soldCopies);
				return "Book registered successfully";
			}
		}
		return "Error: There is no space for more books";
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

	public String ModifyMagazine(String id, String name, int pages, String date, String category, String image, float price, int issuanceFrecuency, int subscriptions, int pagesReaded) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] instanceof Magazine) {
				if (products[i].getId().equals(id)) {
					products[i].setName(name);
					products[i].setPages(pages);
					products[i].setDate(date);
					products[i].setPrice(price);
					products[i].setImage(image);
					((Magazine) products[i]).setCategory(category);
					((Magazine) products[i]).setSubscriptions(subscriptions);
					((Magazine) products[i]).setPagesReaded(pagesReaded);
					((Magazine) products[i]).setIssuanceFrequency(issuanceFrecuency);
					((Magazine) products[i]).setSubscriptions(subscriptions);
					return "Magazine modified successfully";
				}
			}
		}
		return "Error: Magazine not found";
	}

	public String ModifyBook(String id, String name, int pages, String date, int pagesReaded, float price, String image, String review, String genre, int soldCopies) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] instanceof Book) {
				if (products[i].getId().equals(id)) {
					products[i].setName(name);
					products[i].setPages(pages);
					products[i].setDate(date);
					products[i].setPrice(price);
					products[i].setImage(image);
					((Book) products[i]).setGenre(genre);
					((Book) products[i]).setSoldCopies(soldCopies);
					((Book) products[i]).setPagesReaded(pagesReaded);
					return "Book modified successfully";
				}
			}
		}
		return "Error: Book not found";
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