package application;

import basket.Basket;
import basket.ShoppingBasket;
import warehouse.dao.Warehouse;
import warehouse.dao.WarehouseFactory;
import menu.ConsoleMenu;
import menu.Menu;

public class AliExpressApplication {

	private static int dao = 3; // 1 - InMemory, 2 - JDBC, 3 - Hibernate

	public static void main(String[] args) {
		Warehouse warehouse = WarehouseFactory.createWarehouse(dao);
		Basket basket = new ShoppingBasket();
		Menu menu = new ConsoleMenu(warehouse, basket);
		menu.run();
	}
}
