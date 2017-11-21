
public class Pixel {
	private double timestamp;
	private String user_hash;
	private int x, y, color;
	
	public Pixel(double ts, String user, int x, int y, int color) {
		timestamp = ts;
		user_hash = user;
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public double getTimestamp() {
		return timestamp;
	}
	public String user_hash() {
		return user_hash;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getColor() {
		return color;
	}
}
