import java.util.*;

public class Graph {
	
	public String filename;
	public List<String> names;
	public List<String> times;
	public Map<String, Map<String, ArrayList<UserEdge>>> edges;

	public Graph(String file, List<String> names, List<String> times, Map<String, Map<String, ArrayList<UserEdge>>> edges) {
		this.filename = file;
		this.names = names;
		this.times = times;
		this.edges = edges;
	}

}