public class Product {

	private String key;
	private String name;
	private int price;
	private int qty;

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	public Product(String key, String name, int price, int qty) {
		this.key = key;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

}
