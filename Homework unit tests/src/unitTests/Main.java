package unitTests;

public class Main {

	public static void main(String[] args) throws UnknownDistanceFormatException {
		
			String s = "2km+500m";
			MetricDistanceCalculator calc = new MetricDistanceCalculator();
			System.out.println(calc.computeDistance(s, Distance.METERS));
		}


}
