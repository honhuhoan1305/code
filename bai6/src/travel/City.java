package travel;

public class City {
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public City() {
		this.x = (int) (Math.random() * 500);
		this.y = (int) (Math.random() * 500);
	}

	public double distanceToCity(City city) {
		int x = Math.abs(getX() - city.getX());
		int y = Math.abs(getY() - city.getY());
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}