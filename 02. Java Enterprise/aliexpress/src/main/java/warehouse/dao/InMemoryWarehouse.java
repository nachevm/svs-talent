package warehouse.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import warehouse.Product;
import warehouse.ProductParser;
import warehouse.exceptions.GenericDBException;

public class InMemoryWarehouse implements Warehouse {

	public List<Product> getProducts() {
		List<Product> products;
		try {
			products = ProductParser.getProducts();
		} catch (FileNotFoundException e) {
			throw new GenericDBException();
		} catch (IOException e) {
			throw new GenericDBException();
		}
		return products;
	}

	public Product getProduct(String key) {
		List<Product> products = getProducts();
		for (Product product : products) {
			if (key.equals(product.getKey())) {
				return product;
			}
		}
		return null;
	}

}
