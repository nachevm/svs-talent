package warehouse;

import java.util.List;

public interface Warehouse {

	public List<Product> getProducts();

	public Product getProduct(String key) throws NoSuchKeyException;
}
