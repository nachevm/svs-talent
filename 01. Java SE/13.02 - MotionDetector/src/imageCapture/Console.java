package imageCapture;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {

	private Scanner in = new Scanner(System.in);

	public byte[] getImg() {
		System.out.println("Enter image:");
		byte[] img = null;
		try {
			img = in.nextLine().getBytes();
		} catch (NoSuchElementException e) {
			return null;
		}
		return img;
	}
}
