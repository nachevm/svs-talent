package basket;

import java.util.ArrayList;
import java.util.List;

import warehouse.Product;

public class ShoppingBasket implements Basket {

	private ArrayList<Product> products = new ArrayList<Product>();

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Product product) {
		for (Product p : products) {
			if (p.getKey().equals(product.getKey())) {
				products.remove(p);
				break;
			}
		}
	}
}
