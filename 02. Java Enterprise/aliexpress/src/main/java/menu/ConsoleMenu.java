package menu;

import java.util.List;
import java.util.Scanner;

import basket.Basket;
import basket.BasketService;
import logging.ConsoleLogger;
import logging.Logger;
import warehouse.Product;
import warehouse.WarehouseService;
import warehouse.dao.Warehouse;
import warehouse.exceptions.GenericDBException;
import warehouse.exceptions.NoSuchKeyException;
import warehouse.exceptions.NotEnoughQuantityException;

public class ConsoleMenu implements Menu {

	private Scanner in = new Scanner(System.in);
	private WarehouseService warehouseService;
	private BasketService basketService;
	private boolean end = false;
	private Logger logger = new ConsoleLogger();

	public ConsoleMenu(Warehouse warehouse, Basket basket) {
		warehouseService = new WarehouseService(warehouse);
		basketService = new BasketService(basket);
	}

	public void listOptions() {
		System.out.println("1. List Products");
		System.out.println("2. Add product to basket");
		System.out.println("3. Checkout");
		System.out.println("4. Exit");
	}

	public void listProducts() {
		try {
			List<Product> products = warehouseService.getProducts();
			for (Product p : products) {
				System.out.println(p.getKey() + "|" + p.getName() + "|"
						+ p.getPrice());
			}
		} catch (GenericDBException e) {
			logger.log("We're sorry. An error has occured.");
		}
	}

	public void addProductToBasket() {
		try {
			System.out.println("Enter product key:");
			String key = in.next();
			System.out.println("Enter quantity:");
			int qty = Integer.parseInt(in.next())
					+ basketService.getQuantity(key);
			Product p = warehouseService.getProduct(key, qty);
			basketService.add(p, qty);
		} catch (NoSuchKeyException e) {
			logger.log("No such product key!");
		} catch (NotEnoughQuantityException e) {
			logger.log("We're sorry. There's not enough stock in the warehouse.");
		} catch (GenericDBException e) {
			logger.log("We're sorry. An error has occured.");
		}
	}

	public void listBasket() {
		List<Product> products = basketService.getProducts();
		for (Product p : products) {
			System.out.println(p.getKey() + "|" + p.getName() + "|"
					+ p.getPrice() + "|" + p.getQuantity());
		}
		System.out.println("Total: " + basketService.getTotal());
	}

	public void exit() {
		warehouseService.exit();
		in.close();
		end = true;
	}

	public void run() {
		while (!end) {
			listOptions();
			switch (in.nextInt()) {
			case 1:
				listProducts();
				break;
			case 2:
				addProductToBasket();
				break;
			case 3:
				listBasket();
				break;
			case 4:
				exit();
				break;
			default:
				System.out.println("Insert 1-4!");
			}
		}
	}

}
