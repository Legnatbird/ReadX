package model;

import java.util.Calendar;

public class PremiumUser extends User {

	private String name;
	private String id;
	private Calendar registrationDate;
	private Product[] products;

	public PremiumUser(String name, String id) {
		super(name, id);
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id unique id of the user
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Calendar getRegistrationDate() {
		return this.registrationDate;
	}

	/**
	 * 
	 * @param registrationDate date of registration
	 */
	public void setRegistrationDate (Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Product[] getProducts() {
		return this.products;
	}

	/**
	 * 
	 * @param product products bought by the user
	 */
	public void setProducts(Product product) {
		// TODO - implement PremiumUser.setProducts
		throw new UnsupportedOperationException();
	}

}