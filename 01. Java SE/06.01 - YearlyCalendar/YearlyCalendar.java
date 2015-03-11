public class YearlyCalendar {

	public static void main(String[] args) {

		int year = 2015, n;

		if (countDays(2, year) == 28)
			n = 365;
		else
			n = 366;

		String[] calendar = new String[n];

		for (int i = 0, day = 1, month = 1; i < n; i++) {
			calendar[i] = day + "/" + month + "/" + year;
			day++;
			int check = countDays(month, year);
			if (day > check) {
				month++;
				day = 1;
			}
			System.out.println(calendar[i]);
		}
	}

	static int countDays(int month, int year) {
		int count = -1;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			count = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			count = 30;
			break;
		case 2:
			if (year % 4 == 0) {
				count = 29;
			} else {
				count = 28;
			}
			if ((year % 100 == 0) & (year % 400 != 0)) {
				count = 28;
			}
		}
		return count;
	}
}
