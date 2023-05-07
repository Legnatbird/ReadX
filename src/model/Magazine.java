package model;

import java.util.Calendar;

public class Magazine extends Product {

	private String id;
	private String name;
	private int pages;
	private Calendar date;
	private TCategory category;
	private String image;
	private float price;
	private int issuanceFrequency;
	private int subscriptions;
	private int pagesReaded;

	/**
	 * 
	 * @param category
	 * @param issuanceFrecuency
	 * @param subscriptions
	 */
	public Magazine(String id, String name, int pages, String date, int pagesReaded, float price, String image, String category, int issuanceFrequency, int subscriptions) {
		super(id, name, pages, date, pagesReaded, price, image);
		this.category = TCategory.valueOf(category);
		this.issuanceFrequency = issuanceFrequency;
		this.subscriptions = subscriptions;
	}

	public void subscribe() {
		// TODO - implement Magazine.subscribe
		throw new UnsupportedOperationException();
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

	public TCategory getCategory() {
		return this.category;
	}

	/**
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = TCategory.valueOf(category);
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

	public int getIssuanceFrequency() {
		return this.issuanceFrequency;
	}

	/**
	 * 
	 * @param issuanceFrequency
	 */
	public void setIssuanceFrequency(int issuanceFrequency) {
		this.issuanceFrequency = issuanceFrequency;
	}

	public int getSubscriptions() {
		return this.subscriptions;
	}

	/**
	 * 
	 * @param subscriptions
	 */
	public void setSubscriptions(int subscriptions) {
		this.subscriptions = subscriptions;
	}

	public int getPagesReaded() {
		// TODO - implement Magazine.getPagesReaded
		return this.pagesReaded;
	}

	/**
	 * 
	 * @param pagesReaded
	 */
	public void setPagesReaded(int pagesCount) {
		pagesReaded += pagesCount;
	}

}