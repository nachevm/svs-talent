import java.util.ArrayList;

public class Basket {

	private ArrayList<Product> list;

	public Basket() {
		list = new ArrayList<Product>();
	}

	public void checkout() {
		int total = 0;
		System.out.println("Key \tName \t\tPrice \tQuantity");
		for (Product p : list) {
			System.out.println(p.getKey() + "\t" + p.getName() + "\t"
					+ p.getPrice() + "\t" + p.getQty());
			total += p.getPrice() * p.getQty();
		}
		System.out.println("Total: " + total);
	}

	public int getQty(String key) {
		for (Product p : list) {
			if (key.equals(p.getKey())) {
				return p.getQty();
			}
		}
		return 0;
	}

	public void add(Product p1, int qty) {

		for (Product p : list) {
			if (p1.getKey().equals(p.getKey())) {
				list.remove(p);
				break;
			}
		}
		Product p = new Product(p1.getKey(), p1.getName(), p1.getPrice(), qty);
		list.add(p);
	}

}
