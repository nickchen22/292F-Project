import java.util.ArrayList;

public class Edge_Structure {

	private int total_edges;

	private ArrayList<Edge> edges;
	private Position_Nodes nodes;

	public Edge_Structure(Position_Nodes nodes) {
		total_edges =  0;
		edges = new ArrayList<Edge>();
		this.nodes = nodes;
	}

	public void addEdge(Edge e) {
		edges.add(e);
		//printEdge(e);
		total_edges++;
	}

	public void sortByWeight() {
		;
	}

	private void printEdge(Edge e) {
		printPixel(e.getNode1().p);
		System.out.println("CONNECTED TO");
		printPixel(e.getNode2().p);
		System.out.println();
	}

	private void printPixel(Pixel p) {
		System.out.println(p.getTimestamp()+","+p.getUserHash()+","+p.getX()+","+p.getY()+","+p.getColor());
	}

	public int getTotal() {
		return total_edges;
	}

}