public class ZipCodeWithExceptions {

	private int zipCode;

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int z) throws ZipCodeException {
		if ((z > 10000 && z < 99999) || (z > 100000000 & z < 999999999)) {
			zipCode = z;
		} else {
			throw new ZipCodeException();
		}
	}

	public static void main(String[] args) {

		ZipCodeWithExceptions a = new ZipCodeWithExceptions();

		try {
			a.setZipCode(123);
		} catch (ZipCodeException e) {
			System.out.println("5 or 9 digits!");
		}

		try {
			a.setZipCode(123456789);
		} catch (ZipCodeException e) {
			System.out.println("5 or 9 digits!");
		}

		System.out.println(a.getZipCode());
	}

}