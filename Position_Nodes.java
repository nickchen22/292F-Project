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
					ArrayList<Edge> neighbors = checkForNeighbors(matrix[i][j]);
					for (int k = 0; k < neighbors.size(); k++) {
						Node two = neighbors.get(k).getNode2();	
						if (noExistingEdge(matrix[i][j], two))
							edges.addEdge(neighbors.get(k));
					}
					matrix[i][j].neighbors = neighbors;
				}
			}
		}
		System.out.println(edges.getTotal());
	}

	private ArrayList<Edge> checkForNeighbors(Node n) {
		ArrayList<Edge> neighbors = new ArrayList<Edge>();
		int x = n.p.getX();
		int y = n.p.getY();
		for (int k = x - range; k <= x + range; k++) {
			for (int l = y - range; l <= y + range; l++) {

				if (k > -1 && k < 1000 && l > -1 && l < 1000 && k != x && l != y) { //accounts for boundary and self edges
					if (matrix[k][l] != null && matrix[k][l].p.getColor() == n.p.getColor()) {
						Edge e = new Edge(n, matrix[k][l], 0);
						neighbors.add(e);
					}
				}
			}
		}
		return neighbors;
	}

	private boolean noExistingEdge(Node check, Node alreadyExists) {
		for (int i = 0; i < alreadyExists.neighbors.size(); i++) {
			Node one = alreadyExists.neighbors.get(i).getNode1();	
			Node two = alreadyExists.neighbors.get(i).getNode2();
			if (check == one || check == two)
				return false;
		}
		return true;
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

	public ArrayList<UserEdge> getUserNeighbors(int x, int y) {

		Node n = matrix[x][y];
		ArrayList<UserEdge> neighbors = new ArrayList<UserEdge>();

		for (Edge e: n.neighbors) {
			Node neighbor = e.getNode2();

			UserEdge edge = new UserEdge(neighbor.p.getUserHash(), 0);
			neighbors.add(edge);
		}

		return neighbors;
	}

}