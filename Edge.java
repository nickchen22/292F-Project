
public class Edge {

	private double weight;
	private Node node1;
	private Node node2;

	public Edge(Node p, Node q, double w) {
		weight = w;
		node1 = p;
		node2 = q;
	}

	public double getWeight() {
		return weight;
	}

	public Node getNode1() {
		return node1;
	}

	public Node getNode2() {
		return node2;
	}

}