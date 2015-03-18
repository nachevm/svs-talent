public class NumberPrinter {

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(args[0]);

		Thread task = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= n; i++) {
					if (Thread.interrupted()) {
						return;
					}
					System.out.println(i);
				}
			}

		});
		
		task.start();

		task.join(Integer.parseInt(args[1]));
		task.interrupt();
	}

}
