package model;

public class Product {
	
	// private instance variables
	private String productId;
	private String name;
	private String imagefile;
	private double price;
	
	// Constructor
	public Product(String productId, String name, String imagefile, double price) {
		this.productId = productId;
		this.name = name;
		this.imagefile = imagefile;
		this.price = price;
	}
	
	// get id method
	public String getId() {
		return productId;
	}
	
	// get product name
	public String getName() {
		return name;
	}
	
	// get product image file
	public String getImageFile() {
		return imagefile;
	}
	
	// get product price
	public double getPrice() {
		return price;
	}
}
