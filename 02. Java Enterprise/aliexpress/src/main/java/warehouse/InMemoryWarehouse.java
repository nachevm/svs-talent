package warehouse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

	public Product getProduct(String key) throws NoSuchKeyException {
		List<Product> products;
		try {
			products = ProductParser.getProducts();
		} catch (FileNotFoundException e) {
			throw new GenericDBException();
		} catch (IOException e) {
			throw new GenericDBException();
		}
		for (Product product : products) {
			if (key.equals(product.getKey())) {
				return product;
			}
		}
		throw new NoSuchKeyException();
	}

}
