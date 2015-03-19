import java.util.concurrent.TimeUnit;

public class Stopwatch {

	private int i = 1;
	private boolean stop = false;
	private boolean start = false;
	private boolean paused = false;
	private Thread stopwatch = new Thread() {

		@Override
		public void run() {
			while (!stop) {

				// PAUSE
				while (paused) {
					try {
						synchronized (this) {
							wait();
						}
					} catch (InterruptedException e) {
					}
				}

				// PRINT
				System.out.println(i++);

				// WAIT
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
				}
			}
		}

	};

	public void start() {
		if (!start) {
			stopwatch.start();
		}
	}

	public void stop() {
		stop = true;
	}

	public void pause() throws InterruptedException {
		paused = true;
	}

	public void resume() {
		paused = false;
		synchronized (stopwatch) {
			stopwatch.notifyAll();
		}
	}

}