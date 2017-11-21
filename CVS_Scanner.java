import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CVS_Scanner {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("results-20171120-162403.csv"));
		int total_pixels = 0;
		scanner.useDelimiter(",|\\n");
		String categories[] = new String[5];
		for (int i= 0; i < 5; i++) {
			categories[i] = scanner.next(); //eats description first line
		}
		while (scanner.hasNext()) {
			String info[] = new String[5];
			for (int i = 0; i < 5; i++) {
				info[i] = scanner.next();
			}
			Pixel pixel = new Pixel(Double.parseDouble(info[0]), info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]));
			total_pixels++;
		}
		System.out.println(total_pixels);
		scanner.close();
	}
}
