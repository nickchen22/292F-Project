public class Edge {

	private double weight;
	private Pixel node1;
	private Pixel node2;

	public Edge(Pixel p, Pixel q, double w) {
		weight = w;
		node1 = p;
		node2 = q;
	}

	private double getWeight() {
		return weight;
	}

	private Pixel getNode1() {
		return node1;
	}

	private Pixel getNode2() {
		return node2;
	}

}