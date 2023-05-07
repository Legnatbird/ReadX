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
	 * @param name name of the user
	 * @param id id of the user
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
	 * @param id id of the book
	 * @param name name of the book
	 * @param pages number of pages of the book
	 * @param date date of publication of the book
	 * @param price price of the book
	 * @param pagesRead number of pages read of the book
	 * @param issuanceFrequency frequency of issuance of the book
	 * @param subscriptions number of subscriptions of the book
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
	 * @param bookId id of the book
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
	 * @param magazineId id of the magazine
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
	 * @param id id of the book
	 * @param name name of the book
	 * @param pages number of pages of the book
	 * @param date date of publication of the book
	 * @param image image url of the book
	 * @param price price of the book
	 * @param review review of the book
	 * @param pagesRead number of pages read of the book
	 * @param soldCopies number of sold copies of the book
	 */
	public String RegisterBook(String id, String name, int pages, String date, int pagesRead, float price, String image, String review, String genre, int soldCopies) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] == null) {
				products[i] = new Book(id, name, pages, date, pagesRead, price, image, review, genre, soldCopies);
				return "Book registered successfully";
			}
		}
		return "Error: There is no space for more books";
	}

	/**
	 * 
	 * @param userId id of the user
	 * @param bookId id of the book
	 */
	public String BuyBook(String userId, String bookId) {
		// TODO - implement ReadXController.BuyBook
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId id of the user
	 * @param magazineId id of the magazine
	 */
	public String SubscribeMagazine(String userId, String magazineId) {
		// TODO - implement ReadXController.SubscribeMagazine
		throw new UnsupportedOperationException();
	}

	public String ModifyMagazine(String id, String name, int pages, String date, String category, String image, float price, int issuanceFrecuency, int subscriptions, int pagesReaded) {
		for (Product product : products) {
			if (product instanceof Magazine) {
				if (product.getId().equals(id)) {
					product.setName(name);
					product.setPages(pages);
					product.setDate(date);
					product.setPrice(price);
					product.setImage(image);
					product.setPagesReaded(pagesReaded);
					((Magazine) product).setCategory(category);
					((Magazine) product).setSubscriptions(subscriptions);
					((Magazine) product).setIssuanceFrequency(issuanceFrecuency);
					((Magazine) product).setSubscriptions(subscriptions);
					return "Magazine modified successfully";
				}
			}
		}
		return "Error: Magazine not found";
	}

	public String ModifyBook(String id, String name, int pages, String date, int pagesRead, float price, String image, String review, String genre, int soldCopies) {
		for (Product product : products) {
			if (product instanceof Book) {
				if (product.getId().equals(id)) {
					product.setName(name);
					product.setPages(pages);
					product.setDate(date);
					product.setPagesReaded(pagesRead);
					product.setPrice(price);
					product.setImage(image);
					((Book) product).setReview(review);
					((Book) product).setGenre(genre);
					((Book) product).setSoldCopies(soldCopies);
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
	 * @param productId id of the product
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