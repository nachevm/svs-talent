public class Product {

	private String key;
	private String name;
	private int price;
	private int qty;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Product(String key, String name, int price, int qty) {
		this.key = key;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

}
