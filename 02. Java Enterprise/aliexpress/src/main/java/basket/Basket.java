package basket;

import java.util.List;

import warehouse.Product;

public interface Basket {

	List<Product> getProducts();

	void addProduct(Product product);

	void removeProduct(Product product);
}
