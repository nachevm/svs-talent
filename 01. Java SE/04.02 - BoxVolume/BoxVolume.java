public class BoxVolume {

	int height, weight, depth, volume;

	public BoxVolume(int height, int weight, int depth) {
		this.height = height;
		this.weight = weight;
		this.depth = depth;
		volume = height * weight * depth;
	}

	public static void main(String[] args) {
		BoxVolume a = new BoxVolume(6, 5, 3), b = new BoxVolume(2, 2, 2);
		if (a.volume > b.volume)
			System.out.println("H:" + a.height + " W:" + a.weight + " D:"
					+ a.depth + " V:" + a.volume);
		else
			System.out.println("H:" + b.height + " W:" + b.weight + " D:"
					+ b.depth + " V:" + b.volume);
	}
}
