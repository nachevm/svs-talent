import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Warehouse warehouse = new Warehouse();
		Basket basket = new Basket();
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.println("1. List Products");
			System.out.println("2. Add product to basket");
			System.out.println("3. Checkout");
			System.out.println("4. Exit");

			switch (in.nextInt()) {
			case 1: // LIST PRODUCTS
				warehouse.print();
				break;
			case 2: // ADD PRODUCT TO BASKET
				try {
					System.out.println("Enter product key:");
					String key = in.next();
					System.out.println("Enter quantity:");
					int qty = in.nextInt() + basket.getQty(key);

					Product p = warehouse.getProduct(key, qty);
					basket.add(p, qty);
				} catch (InputMismatchException e) {
					System.out.println("Error: Insert number for quantity!");
				} catch (ProductKeyException e) {
					System.out.println("Error: Wrong product key!");
				} catch (QtyException e) {
					System.out
							.println("Error: Not enough quantity in warehouse!");
				}
				break;
			case 3: // CHECKOUT
				basket.checkout();
				break;
			case 4: // EXIT
				in.close();
				System.exit(0);
				break;
			}
		}
	}

}
