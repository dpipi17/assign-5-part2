package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShopCart {

	// private instance variable
	private Map<String, Integer> data;
	
	// Constructor
	public ShopCart() {
		data = new HashMap<String, Integer>();
	}
	
	// add new item into cart 
	public void addToCart(String id) {
		if(!data.containsKey(id)) {
			data.put(id, 1);
		} else {
			int lastVal = data.get(id);
			data.put(id, lastVal + 1);
		}
	}
	
	// set new value for item
	// if new value <= 0 erase it from cart
	public void setNewValue(String id, int num) {
		data.put(id, num);
		
		if(num <= 0) {
			data.remove(id);
		}
	}
	
	// get quantity of the item
	public int getOccur(String id) {
		return data.get(id);
	}
	
	// get set of the all product ids which is in the cart
	public Set<String> allIds() {
		return data.keySet();
	}
}
