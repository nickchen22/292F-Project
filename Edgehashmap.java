import java.util.*;

public class Edgehashmap {

	Map<String, Map<Edge, List<Object>>> EdgeHashMap = new HashMap<String, Map<Edge, List<Object>>>();

	public void EdgeMap(String userID, Edge edges, String weight, Node node1, Node node2){
		Map<Edge, List<Object>> innerMap = new HashMap<Edge, List<Object>>();
		List<Object> edgesData = new ArrayList<Object>();
		edgesData.add(node1);
		edgesData.add(node2);
		edgesData.add(weight);

		innerMap.put(edges, edgesData);
		EdgeHashMap.put(userID, innerMap);

	}



}