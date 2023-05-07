package model;

import java.util.Calendar;

public abstract class Product {

	private String id;
	private String name;
	private int pages;
	private Calendar date;
	private int pagesRead;
	private float price;
	private String image;

	/**
	 * 
	 * @param id unique id of the product
	 * @param name name of the product
	 * @param pages number of pages of the product
	 * @param date date of the product
	 * @param pagesRead number of pages read of the product
	 * @param price price of the product
	 * @param image image of the product
	 */
	public Product(String id, String name, int pages, String date, int pagesRead, float price, String image) {
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id unique id of the product
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name name of the product
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return this.pages;
	}

	/**
	 * 
	 * @param pages number of pages of the product
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	public Calendar getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date date of the product
	 */
	public void setDate(String date) {
		// Convert String to Calendar, the format of the string is DD/MM/YYYY
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(0, 2)));
		cal.set(Calendar.MONTH, Integer.parseInt(date.substring(3, 5)));
		cal.set(Calendar.YEAR, Integer.parseInt(date.substring(6, 10)));
		this.date = cal;
	}

	public int getPagesRead() {
		return this.pagesRead;
	}

	/**
	 * 
	 * @param pagesRead number of pages read of the product
	 */
	public void setPagesRead(int pagesRead) {
		this.pagesRead = pagesRead;
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price price of the product
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return this.image;
	}

	/**
	 * 
	 * @param image image of the product
	 */
	public void setImage(String image) {
		this.image = image;
	}

}