import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import javafx.util.*;
import java.util.*;

public class CVS_Scanner {

	//node structures
	private static Position_Nodes positions;

	//edge structures


	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("100x100_427-527.csv"));
		scanner.useDelimiter(",|\\n");
		String categories[] = new String[5];

		Map<String, Map<String, List<String>>> userdata = new HashMap<String, Map<String, List<String>>>();
		Map<String, ArrayList<UserEdge>> EdgeHashMap = new HashMap<String,ArrayList<UserEdge>>();

		for (int i= 0; i < 5; i++) {
			categories[i] = scanner.next(); //eats description first line
		}

		intitializeNodeStructures();

		while (scanner.hasNext()) {
			String info[] = new String[5];
			for (int i = 0; i < 5; i++) {
				info[i] = scanner.next();
			}
			Map<String, List<String>> innerMap = new HashMap<String, List<String>>();
			List<String> x_y_color = new ArrayList<String>();
			x_y_color.add(info[2]);
			x_y_color.add(info[3]);
			x_y_color.add(info[4]);

			innerMap.put(info[0],x_y_color);
			userdata.put(info[1], innerMap);


			EdgeHashMap.put(info[0], positions.getUserNeighbors(Integer.parseInt(info[2]), Integer.parseInt(info[3])));

			String action = info[2] + "/" + info[3] + "/" + info[4];
			//UserData.put(info[1], info[0], action);

			Pixel pixel = new Pixel(Double.parseDouble(info[0]), info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]));
			addPixelToStructures(pixel);
		}

		createStructureEdges();

		scanner.close();
	}

	private static void intitializeNodeStructures() {
		positions = new Position_Nodes(1000, 1000);
		//any other structure initializations
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
