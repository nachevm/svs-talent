package basket;

import java.util.ArrayList;
import warehouse.Product;

public class Basket {

	private ArrayList<Product> products = new ArrayList<Product>();

	public ArrayList<Product> getProducts() {
		return products;
	}

	public int getTotal() {
		int total = 0;
		for (Product p : products) {
			total += p.getPrice() * p.getQuantity();
		}
		return total;
	}

	public int getQuantity(String key) {
		for (Product p : products) {
			if (key.equals(p.getKey())) {
				return p.getQuantity();
			}
		}
		return 0;
	}

	public void add(Product p1, int qty) {

		for (Product p : products) {
			if (p1.getKey().equals(p.getKey())) {
				products.remove(p);
				break;
			}
		}
		products.add(new Product(p1.getKey(), p1.getName(), p1.getPrice(), qty));
	}
}
