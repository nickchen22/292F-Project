import java.util.*;
import java.io.*;
public class Algorithms {

	public ArrayList<Graph> graphs;
	public PrintWriter writer;

	public Algorithms() throws Exception {
		graphs = new ArrayList<Graph>();
		writer = new PrintWriter("output.txt", "UTF-8");
	}

	public void analysis() {
		for (Graph g : graphs) {
			writer.println("File: " + g.filename);
			preliminary(g);
			secondary(g);
			tertiary(g);
			writer.println();
		}
	}

	public void addGraph(String filename, List<String> names, List<String> times, Map<String, Map<String, ArrayList<UserEdge>>> edges) {
		Graph g = new Graph(filename, names, times, edges);
		graphs.add(g);
	}

	private void preliminary(Graph g) {
		double num_nodes = g.names.size();
		double num_edges = 0;
		for(String name : g.names) {
			Map<String, ArrayList<UserEdge>> temp = g.edges.get(name);
			for (String time : g.times) {
				if (temp.containsKey(time))
					num_edges += temp.get(time).size();
			}
		}
		writer.println("Average degree: " + (num_edges/num_nodes));
	}

	private void secondary(Graph g) {
		;
	}

	private void tertiary(Graph g) {
		;
	}

	public void shutdown() {
		writer.close();
	}

}