package basket;

import java.util.List;

import warehouse.Product;

public class BasketService {

	private Basket basket;

	public BasketService(Basket b) {
		basket = b;
	}

	public List<Product> getProducts() {
		return basket.getProducts();
	}

	public int getTotal() {
		List<Product> products = basket.getProducts();
		int total = 0;
		for (Product p : products) {
			total += p.getPrice() * p.getQuantity();
		}
		return total;
	}

	public int getQuantity(String key) {
		List<Product> products = basket.getProducts();
		for (Product p : products) {
			if (key.equals(p.getKey())) {
				return p.getQuantity();
			}
		}
		return 0;
	}

	public void add(Product p, int qty) {
		basket.removeProduct(p);
		Product product = new Product(p.getKey(), p.getName(), p.getPrice(),
				qty);
		basket.addProduct(product);
	}
}
