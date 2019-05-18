package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShopCart {

	private Map<String, Integer> data;
	
	public ShopCart() {
		data = new HashMap<String, Integer>();
	}
	
	
	public void addToCart(String id) {
		if(!data.containsKey(id)) {
			data.put(id, 1);
		} else {
			int lastVal = data.get(id);
			data.put(id, lastVal + 1);
		}
	}
	
	public void setNewValue(String id, int num) {
		data.put(id, num);
		
		if(num == 0) {
			data.remove(id);
		}
	}
	
	public int getOccur(String id) {
		return data.get(id);
	}
	
	public boolean inCart(String id) {
		return data.containsKey(id);
	}
	
	public Set<String> allIds() {
		return data.keySet();
	}
}
