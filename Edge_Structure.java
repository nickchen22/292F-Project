import java.util.ArrayList;

public class Edge_Structure {

	private int total_edges;

	private ArrayList<Edge> edges;
	private Position_Nodes nodes;

	public Edge_Structure(Position_Nodes nodes) {
		edges = new ArrayList<Edge>();
		this.nodes = nodes;
	}

	public void addEdge(Edge e) {
		edges.add(e);
	}

	public void sortByWeight() {
		;
	}


}