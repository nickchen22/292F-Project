import java.util.ArrayList;

public class Node {

	public Pixel p;
	public ArrayList<Edge> neighbors;

	public Node(Pixel p) {
		this.p = p;
		neighbors = new ArrayList<Edge>();
	}

}