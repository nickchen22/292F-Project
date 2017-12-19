import java.util.*;
import java.io.*;
public class Algorithms {

	public ArrayList<Graph> graphs;
	public PrintWriter writer;

	public Algorithms() throws Exception {
		graphs = new ArrayList<Graph>();
		writer = new PrintWriter("output.txt", "UTF-8");
	}

	private void preliminaryAnalysis() {
		System.out.println("Mean degree: ");
		System.out.println("Degree distribution: ");
	}

	public void addGraph(List<String> names, List<String> times, Map<String, Map<String, ArrayList<UserEdge>>> edges) {
		Graph g = new Graph(names, times, edges);
		graphs.add(g);
	}

	public void shutdown() {
		writer.close();
	}

	public void writeToFile(String text) {
		writer.println(text);
	}

}