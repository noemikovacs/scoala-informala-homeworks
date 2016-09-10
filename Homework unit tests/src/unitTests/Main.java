package unitTests;

public class Main {

	public static void main(String[] args) throws UnknownDistanceFormatException {
		
			String s = "2mi+500m+11dm";
			MetricDistanceCalculator calc = new MetricDistanceCalculator();
			System.out.println(calc.computeDistance(s, Distance.METERS));
		}


}
