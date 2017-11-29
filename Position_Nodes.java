
public class Position_Nodes {

	public Pixel matrix[][];
	private int min_x;
	private int max_x;
	private int min_y;
	private int max_y;
	private int total_nodes;

	public Position_Nodes(int x_length, int y_length) {
		matrix = new Pixel[x_length][y_length];
		min_x = 999;
		min_y = 999;
		max_x = 0;
		max_y = 0;
		total_nodes = 0;
	}

	public void add(Pixel p) {
		int x_coordinate = p.getX();
		int y_coordinate = p.getY();
		matrix[x_coordinate][y_coordinate] = p;

		//limits scope of the area by the given points
		//worst case results in computing over entire canvas
		if (x_coordinate < min_x)
			min_x = x_coordinate;
		if (x_coordinate > max_x)
			max_x = x_coordinate;
		if (y_coordinate < min_y)
			min_y = y_coordinate;
		if (y_coordinate > max_y)
			max_y = y_coordinate;

		total_nodes++;

	}

	public int getMinX() {
		return min_x;
	}

	public int getMinY() {
		return min_y;
	}

	public int getMaxX() {
		return max_x;
	}

	public int getMaxY() {
		return max_y;
	}

	public int getTotalNodes() {
		return total_nodes;
	}

}