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
	private int pagesReaded;

	/**
	 * 
	 * @param review
	 * @param genre
	 * @param soldCopies
	 */
	public Book(String id, String name, int pages, String date, int pagesReaded, float price, String image, String review, String genre, int soldCopies) {
		super(id, name, pages, date, pagesReaded, price, image);
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

	public String getReview() {
		return this.review;
	}

	/**
	 * 
	 * @param review
	 */
	public void setReview(String review) {
		this.review = review;
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

	public TGenre getGenre() {
		return this.genre;
	}

	/**
	 * 
	 * @param genre
	 */
	public void setGenre(TGenre genre) {
		this.genre = genre;
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

	public int getSoldCopies() {
		return this.soldCopies;
	}

	/**
	 * 
	 * @param soldCopies
	 */
	public void setSoldCopies(int soldCopies) {
		this.soldCopies = soldCopies;
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

}