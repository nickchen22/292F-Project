import java.util.ArrayList;

public class Position_Nodes {


	public Node matrix[][];
	private int min_x;
	private int max_x;
	private int min_y;
	private int max_y;
	private int total_nodes;
	public Edge_Structure edges;

	private int range;

	public Position_Nodes(int x_length, int y_length) {
		matrix = new Node[x_length][y_length];
		min_x = 999;
		min_y = 999;
		max_x = 0;
		max_y = 0;
		total_nodes = 0;
		range = 1;
		edges = new Edge_Structure(this);
	}

	public void add(Pixel p) {
		int x_coordinate = p.getX();
		int y_coordinate = p.getY();

		Node node = new Node(p);
		matrix[x_coordinate][y_coordinate] = node;

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

	public void createEdges() {
		for (int i = min_x; i <= max_x; i++) {
			for (int j = min_y; j <= max_y; j++) {
				//for loop for each pixel in the grid
				if (matrix[i][j] != null) {
					//following for loop checks the range of pixels nearby for similarities
					for (int k = i - range; k <= i + range; k++) {
						for (int l = j - range; j <= l + range; l++) {

							if (k > 0 && k < 999 && l > 0 && l < 999 && k != i && l != j) { //accounts for boundary and self edges
								if (matrix[k][l] != null && matrix[k][l].p.getColor() == matrix[i][j].p.getColor()) {
									Edge e = new Edge(matrix[i][j], matrix[k][l], 0);
									matrix[i][j].neighbors.add(e);
									edges.addEdge(e);
								}
							}
						}
					}
				}
			}
		}
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

	public int getTotal() {
		return total_nodes;
	}

}