import java.util.ArrayList;

public class Warehouse {

	private ArrayList<Product> list = Parser.getProducts();

	public void print() {
		System.out.println("Key \tName \t\tPrice");
		for (Product p : list) {
			System.out.println(p.getKey() + "\t" + p.getName() + "\t"
					+ p.getPrice());
		}
	}

	public Product getProduct(String key, int qty) throws ProductKeyException,
			QtyException {
		for (Product p : list) {
			if (key.equals(p.getKey())) {
				if (p.getQty() >= qty) {
					return p;
				} else {
					throw new QtyException();
				}
			}
		}
		throw new ProductKeyException();
	}
}
