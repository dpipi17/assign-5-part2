package sql_query;

import java.util.List;

import model.Product;

public interface IQuery {

	public List<Product> selectAll();
	public Product getProduct(String id);
}
