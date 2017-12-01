import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CVS_Scanner {

	//node structures
	private static Position_Nodes positions;

	//edge structures


	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("results-20171120-162403.csv"));
		scanner.useDelimiter(",|\\n");
		String categories[] = new String[5];
		for (int i= 0; i < 5; i++) {
			categories[i] = scanner.next(); //eats description first line
		}

		intitializeNodeStructures();

		while (scanner.hasNext()) {
			String info[] = new String[5];
			for (int i = 0; i < 5; i++) {
				info[i] = scanner.next();
			}
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
