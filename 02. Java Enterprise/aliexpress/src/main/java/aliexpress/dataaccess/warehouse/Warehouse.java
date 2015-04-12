package aliexpress.dataaccess.warehouse;

import java.util.List;
import aliexpress.model.Product;

public interface Warehouse {

	List<Product> getProducts();

	Product getProduct(String key);

	void update(Product product);

	public void insert(Product product);

	public void delete(Product product);
}
