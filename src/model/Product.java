package model;

import java.util.Calendar;

public abstract class Product {

	private String id;
	private String name;
	private int pages;
	private Calendar date;
	private int pagesReaded;
	private float price;
	private String image;

	/**
	 * 
	 * @param id
	 * @param name
	 * @param pages
	 * @param date
	 * @param pagesReaded
	 * @param price
	 * @param image
	 */
	public Product(String id, String name, int pages, String date, int pagesReaded, float price, String image) {
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

	public int getPages() {
		return this.pages;
	}

	/**
	 * 
	 * @param pages
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	public Calendar getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	public int getPagesReaded() {
		return this.pagesReaded;
	}

	/**
	 * 
	 * @param pagesReaded
	 */
	public void setPagesReaded(int pagesReaded) {
		this.pagesReaded = pagesReaded;
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return this.image;
	}

	/**
	 * 
	 * @param image
	 */
	public void setImage(String image) {
		this.image = image;
	}

}