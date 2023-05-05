package model;

import java.util.Calendar;

public class RegularUser extends User implements Advertisable {

	private String name;
	private String id;
	private Calendar registrationDate;
	private Product[] products;
	private short booksCount;
	private short magazineCount;

	public RegularUser(String name, String id) {
		// TODO - implement RegularUser.RegularUser
		super(name, id);
		throw new UnsupportedOperationException();
	}

	public String showAds() {
		// TODO - implement RegularUser.showAds
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Calendar getRegistrationDate() {
		return this.registrationDate;
	}

	/**
	 * 
	 * @param registrationDate
	 */
	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Product[] getProducts() {
		return this.products;
	}

	/**
	 * 
	 * @param product
	 */
	public void setProducts(Product product) {
		// TODO - implement RegularUser.setProducts
		throw new UnsupportedOperationException();
	}

	public short getBooksCount() {
		return this.booksCount;
	}

	/**
	 * 
	 * @param booksCount
	 */
	public void setBooksCount(short booksCount) {
		this.booksCount = booksCount;
	}

	public short getMagazineCount() {
		return this.magazineCount;
	}

	/**
	 * 
	 * @param magazineCount
	 */
	public void setMagazineCount(short magazineCount) {
		this.magazineCount = magazineCount;
	}

}