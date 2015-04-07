package warehouse.dao;

import java.util.List;

import warehouse.Product;

public interface Warehouse {

	List<Product> getProducts();

	Product getProduct(String key);
}
