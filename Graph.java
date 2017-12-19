import java.util.*;

public class Graph {
	
	public List<String> names;
	public List<String> times;
	public Map<String, Map<String, ArrayList<UserEdge>>> edges;

	public Graph(List<String> names, List<String> times, Map<String, Map<String, ArrayList<UserEdge>>> edges) {
		this.names = names;
		this.times = times;
		this.edges = edges;
	}

}