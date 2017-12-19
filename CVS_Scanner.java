import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import javafx.util.*;
import java.util.*;

public class CVS_Scanner {

	//node structures
	private static Position_Nodes positions;

	//edge structures


	public static void main(String[] args) throws Exception {
		File folder = new File("data/");
		File[] listOfFiles = folder.listFiles();
		Algorithms algs = new Algorithms();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	algs.writeToFile("File: " + file.getName());
    			positions = new Position_Nodes(1000, 1000, 1);
		    	Scanner scanner = new Scanner(file);
		    	scanner.useDelimiter(",|\\n");
		    	while (scanner.hasNext()) {
					String categories[] = new String[5];
					List<String> Namelist = new ArrayList<String>();
					List<String> Timelist = new ArrayList<String>();

					Map<String, Map<String, List<String>>> Usermap = new HashMap<String, Map<String, List<String>>>();
					Map<String, Map<String, ArrayList<UserEdge>>> EdgeMap = new HashMap<String, Map<String, ArrayList<UserEdge>>>();


					for (int i= 0; i < 5; i++) {
						categories[i] = scanner.next(); //eats description first line
					}

					while (scanner.hasNext()) {
						String info[] = new String[5];
						for (int i = 0; i < 5; i++) {
							info[i] = scanner.next();
						}

						Namelist.add(info[1]);

						if(!Timelist.contains(info[0])){
							Timelist.add(info[0]);
						}

						Map<String, List<String>> level1map = new HashMap<String, List<String>>();
						List<String> x_y_color = new ArrayList<String>();
						x_y_color.add(info[2]);
						x_y_color.add(info[3]);
						x_y_color.add(info[4]);

						if(Usermap.containsKey(info[1])){
							Map<String, List<String>> temp = Usermap.get(info[1]);
							temp.put(info[0],x_y_color);
						}
						else{
							level1map.put(info[0],x_y_color);
							Usermap.put(info[1], level1map);
						}
						


						String action = info[2] + "/" + info[3] + "/" + info[4];
						//UserData.put(info[1], info[0], action);

						Pixel pixel = new Pixel(Double.parseDouble(info[0]), info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]));
						addPixelToStructures(pixel);
					}

					createStructureEdges();

					// Store all related edges according to each user and each timestamp for the user
					for(int i = 0; i < Namelist.size(); i++){
						Map<String, List<String>> temp = Usermap.get(Namelist.get(i));
						for(int j = 0; j< Timelist.size(); j++){
							if(temp.containsKey(Timelist.get(j))){
								int x = Integer.parseInt((temp.get(Timelist.get(j))).get(0));
								int y = Integer.parseInt((temp.get(Timelist.get(j))).get(1));
								Map<String, ArrayList<UserEdge>> temp1 = new HashMap<String, ArrayList<UserEdge>>();
								temp1.put(Timelist.get(j), positions.getUserNeighbors(x, y));
								EdgeMap.put(Namelist.get(i), temp1);
							}
						}
					}
					algs.addGraph(Namelist, Timelist, EdgeMap);
				}
				scanner.close();
		    }
		}
		algs.shutdown();
	}

	private static void addPixelToStructures(Pixel p) {
		positions.add(p);
	}

	private static void printPixel(Pixel p) {
		System.out.println(p.getTimestamp()+","+p.getUserHash()+","+p.getX()+","+p.getY()+","+p.getColor());
	}

	private static void createStructureEdges() {
		positions.createEdges();
	}
}
