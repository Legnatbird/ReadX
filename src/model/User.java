package model;

import java.util.Calendar;

public abstract class User {

	private String name;
	private String idNumber;
	private Calendar registrationDate;
	private Product[] products;

	/**
	 * 
	 * @param name name of the user
	 * @param id unique id of the user
	 */
	public User(String name, String id) {
		// TODO - implement User.User
		this.name = name;
		this.idNumber = id;
		this.registrationDate = Calendar.getInstance();
		
		throw new UnsupportedOperationException();
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

	public String getIdNumber() {
		return this.idNumber;
	}

	/**
	 * 
	 * @param idNumber unique id of the user
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Calendar getRegistrationDate() {
		return this.registrationDate;
	}

	/**
	 * 
	 * @param registrationDate date of registration
	 */
	public void setRegistrationDate(Calendar registrationDate) {
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
		// TODO - implement User.setProducts
		throw new UnsupportedOperationException();
	}

}