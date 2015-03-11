public class Numbers {

	public static void main(String[] args) {

		int suma = 0;
		int pow = args.length - 1;

		for (int i = 0; i < args.length; i++)
			switch (args[i]) {
			case "one":
				suma += 1 * Math.pow(10, pow--);
				break;
			case "two":
				suma += 2 * Math.pow(10, pow--);
				break;
			case "three":
				suma += 3 * Math.pow(10, pow--);
				break;
			case "four":
				suma += 4 * Math.pow(10, pow--);
				break;
			case "five":
				suma += 5 * Math.pow(10, pow--);
				break;
			case "six":
				suma += 6 * Math.pow(10, pow--);
				break;
			case "seven":
				suma += 7 * Math.pow(10, pow--);
				break;
			case "eight":
				suma += 8 * Math.pow(10, pow--);
				break;
			case "nine":
				suma += 9 * Math.pow(10, pow--);
				break;
			default:
				suma += 0 * Math.pow(10, pow--);
			}

		System.out.println(suma);
	}

}
