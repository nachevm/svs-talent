import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ComplexCalculation implements Callable<Integer> {

	private Integer orderNumber;

	public ComplexCalculation(Integer i) {
		orderNumber = i;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println(orderNumber + " started");
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);
		} catch (InterruptedException e) {
		}
		System.out.println(orderNumber + " completed");

		return new Random().nextInt(1000 + 1);
	}

}
