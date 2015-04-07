package warehouse;

import java.util.List;

import warehouse.dao.HibernateWarehouse;
import warehouse.dao.Warehouse;
import warehouse.exceptions.NoSuchKeyException;
import warehouse.exceptions.NotEnoughQuantityException;

public class WarehouseService {

	private Warehouse warehouse;

	public WarehouseService(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public List<Product> getProducts() {
		return warehouse.getProducts();
	}

	public Product getProduct(String key, int qty)
			throws NotEnoughQuantityException, NoSuchKeyException {
		Product product = warehouse.getProduct(key);
		if (product == null) {
			throw new NoSuchKeyException();
		}
		if (product.getQuantity() < qty) {
			throw new NotEnoughQuantityException();
		}
		return product;
	}

	public void exit() {
		if (warehouse instanceof HibernateWarehouse) {
			((HibernateWarehouse) warehouse).exit();
		}
	}

}
