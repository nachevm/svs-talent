public class ZipCode {

	private int zipCode;

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int z) {
		if ((z > 10000 && z < 99999) || (z > 100000000 & z < 999999999))
			zipCode = z;
		else
			System.out.println("5 or 9 digits!");
	}

	public static void main(String[] args) {
		ZipCode a = new ZipCode();
		a.setZipCode(123);
		a.setZipCode(12345);
		System.out.println(a.getZipCode());
		a.setZipCode(123456789);
		System.out.println(a.getZipCode());
	}
}
