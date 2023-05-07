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
	private int pagesRead;

	/**
	 * 
	 * @param category category of the magazine
	 * @param issuanceFrequency number of times the magazine is issued per year
	 * @param subscriptions number of subscriptions
	 */
	public Magazine(String id, String name, int pages, String date, int pagesRead, float price, String image, String category, int issuanceFrequency, int subscriptions) {
		super(id, name, pages, date, pagesRead, price, image);
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
	 * @param id unique id of the magazine
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name name of the magazine
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return this.pages;
	}

	/**
	 * 
	 * @param pages number of pages of the magazine
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	public Calendar getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date date of the magazine
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	public TCategory getCategory() {
		return this.category;
	}

	/**
	 * 
	 * @param category category of the magazine
	 */
	public void setCategory(String category) {
		this.category = TCategory.valueOf(category);
	}

	public String getImage() {
		return this.image;
	}

	/**
	 * 
	 * @param image image of the magazine
	 */
	public void setImage(String image) {
		this.image = image;
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price price of the magazine
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	public int getIssuanceFrequency() {
		return this.issuanceFrequency;
	}

	/**
	 * 
	 * @param issuanceFrequency number of times the magazine is issued per year
	 */
	public void setIssuanceFrequency(int issuanceFrequency) {
		this.issuanceFrequency = issuanceFrequency;
	}

	public int getSubscriptions() {
		return this.subscriptions;
	}

	/**
	 * 
	 * @param subscriptions number of subscriptions
	 */
	public void setSubscriptions(int subscriptions) {
		this.subscriptions = subscriptions;
	}

	public int getPagesRead() {
		// TODO - implement Magazine.getPagesRead
		return this.pagesRead;
	}

	/**
	 * 
	 * @param pagesCount number of pages read
	 */
	public void setPagesRead(int pagesCount) {
		pagesRead += pagesCount;
	}

}