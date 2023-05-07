package model;

import java.util.Calendar;

public class Book extends Product {

	private String id;
	private String name;
	private int pages;
	private String review;
	private Calendar date;
	private TGenre genre;
	private String image;
	private float price;
	private int soldCopies;
	private int pagesRead;

	/**
	 * 
	 * @param review short review of the book
	 * @param genre genre of the book
	 * @param soldCopies number of sold copies
	 */
	public Book(String id, String name, int pages, String date, int pagesRead, float price, String image, String review, String genre, int soldCopies) {
		super(id, name, pages, date, pagesRead, price, image);
		this.review = review;
		this.genre = TGenre.valueOf(genre);
		this.soldCopies = soldCopies;
	}

	public void sell() {
		// TODO - implement Book.sell
		throw new UnsupportedOperationException();
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id unique id of the book
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name name of the book
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return this.pages;
	}

	/**
	 * 
	 * @param pages number of pages of the book
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getReview() {
		return this.review;
	}

	/**
	 * 
	 * @param review short review of the book
	 */
	public void setReview(String review) {
		this.review = review;
	}

	public Calendar getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date date of the book
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	public TGenre getGenre() {
		return this.genre;
	}

	/**
	 * 
	 * @param genre genre of the book
	 */
	public void setGenre(String genre) {
		this.genre = TGenre.valueOf(genre);
	}

	public String getImage() {
		return this.image;
	}

	/**
	 * 
	 * @param image image of the book
	 */
	public void setImage(String image) {
		this.image = image;
	}

	public int getSoldCopies() {
		return this.soldCopies;
	}

	/**
	 * 
	 * @param soldCopies number of sold copies
	 */
	public void setSoldCopies(int soldCopies) {
		this.soldCopies = soldCopies;
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price price of the book
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	public int getPagesRead() {
		return this.pagesRead;
	}

	/**
	 * 
	 * @param pagesRead number of pages read
	 */
	public void setPagesReaded(int pagesRead) {
		this.pagesRead = pagesRead;
	}

}