package sql_query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data_base.DB;
import model.Product;

public class Query implements IQuery {
	
	@Override
	public List<Product> selectAll() {
		List<Product> result = new ArrayList<Product>();
		
		String query = "SELECT * FROM " + DB.database;
		ResultSet rs = getRsSet(query);
		
		try {
			while (rs.next()) {
				String productid = rs.getString("productid");
				String name = rs.getString("name");
				String image = rs.getString("imagefile");
				double price = rs.getDouble("price");
				
				Product product = new Product(productid, name, image, price);
				result.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		return result;
	}

	@Override
	public Product getProduct(String id) {
		Product product = null;
		String query = "SELECT * FROM " + DB.database;
		query += " WHERE productid = '" + id + "'";
		
		ResultSet rs = getRsSet(query);
		
		try {
			if (rs.next()) {
				String productid = rs.getString("productid");
				String name = rs.getString("name");
				String image = rs.getString("imagefile");
				double price = rs.getDouble("price");
				
				product = new Product(productid, name, image, price);
			}
		} catch (SQLException e) {
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			e.printStackTrace();
		}
		
		return product;
	}

	
	private ResultSet getRsSet(String query) {
		
		try {
			Statement stmt;
			stmt = DB.getCon().createStatement();
			stmt.executeQuery("USE " + DB.database);
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
