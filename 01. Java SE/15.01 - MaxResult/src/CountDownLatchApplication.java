import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchApplication {

	private static final int NUMBER_OF_OPERATIONS = 10;

	public static void main(String[] args) throws Exception {

		int max = Integer.MIN_VALUE;
		ExecutorService executorService = Executors
				.newFixedThreadPool(NUMBER_OF_OPERATIONS);
		ArrayList<Future<Integer>> complexList = new ArrayList<Future<Integer>>();

		for (int i = 1; i <= NUMBER_OF_OPERATIONS; i++) {
			complexList.add(executorService.submit(new ComplexCalculation(i)));
		}
		for (Future<Integer> complexCalculationFuture : complexList) {
			Integer result = complexCalculationFuture.get();
			if (result > max) {
				max = result;
			}
		}
		System.out.println("Max = " + max);

		executorService.shutdown();
	}
}
