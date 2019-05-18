package model;

public class Product {
	
	private String productId;
	private String name;
	private String imagefile;
	private double price;
	
	public Product(String productId, String name, String imagefile, double price) {
		this.productId = productId;
		this.name = name;
		this.imagefile = imagefile;
		this.price = price;
	}
	
	public String getId() {
		return productId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getImageFile() {
		return imagefile;
	}
	
	public double getPrice() {
		return price;
	}
}
