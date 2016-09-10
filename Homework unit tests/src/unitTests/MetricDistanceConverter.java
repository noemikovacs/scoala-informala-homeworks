package unitTests;

public class MetricDistanceConverter {
	private static final Convertion [] CONVERTIONS = new Convertion[]{
			new Convertion(Distance.MILLIMETERS, Distance.CENTIMETERS, 0.1),
			new Convertion(Distance.MILLIMETERS, Distance.DECIMETERS, 0.01),
			new Convertion(Distance.MILLIMETERS, Distance.METERS, 0.001),
			new Convertion(Distance.MILLIMETERS, Distance.KILOMETERS, 0.000001),
			new Convertion(Distance.MILLIMETERS, Distance.HECTOMETERS, 0.00001),
			new Convertion(Distance.MILLIMETERS, Distance.INCHES, 0.0393701),
			new Convertion(Distance.MILLIMETERS, Distance.FOOT, 0.0032808),
			new Convertion(Distance.MILLIMETERS, Distance.MILES, 6.213715),
			new Convertion(Distance.DECIMETERS, Distance.MILLIMETERS,100 ),
			new Convertion(Distance.DECIMETERS, Distance.CENTIMETERS,10 ),
			new Convertion(Distance.DECIMETERS, Distance.METERS,0.1 ),
			new Convertion(Distance.DECIMETERS, Distance.HECTOMETERS,0.001 ),
			new Convertion(Distance.DECIMETERS, Distance.KILOMETERS,0.0001 ),
			new Convertion(Distance.DECIMETERS, Distance.INCHES, 3.93701),
			new Convertion(Distance.DECIMETERS, Distance.FOOT, 0.328084),
			new Convertion(Distance.DECIMETERS, Distance.MILES, 6.213715),
			new Convertion(Distance.CENTIMETERS, Distance.MILLIMETERS, 10),
			new Convertion(Distance.CENTIMETERS, Distance.DECIMETERS, 0.1),
			new Convertion(Distance.CENTIMETERS, Distance.METERS, 0.01),
			new Convertion(Distance.CENTIMETERS, Distance.HECTOMETERS, 0.0001),
			new Convertion(Distance.CENTIMETERS, Distance.KILOMETERS, 0.00001),
			new Convertion(Distance.CENTIMETERS, Distance.INCHES, 0.393701),
			new Convertion(Distance.CENTIMETERS, Distance.FOOT, 0.0328084),
			new Convertion(Distance.CENTIMETERS, Distance.MILES, 6.2137152),
			new Convertion(Distance.METERS, Distance.MILLIMETERS, 1000),
			new Convertion(Distance.METERS, Distance.CENTIMETERS, 100),
			new Convertion(Distance.METERS, Distance.DECIMETERS, 10),
			new Convertion(Distance.METERS, Distance.HECTOMETERS, 0.01),
			new Convertion(Distance.METERS, Distance.KILOMETERS, 0.001),
			new Convertion(Distance.METERS, Distance.INCHES,39.370100),
			new Convertion(Distance.METERS, Distance.FOOT, 3.2808416),
			new Convertion(Distance.METERS, Distance.MILES, 0.0006213),
			new Convertion(Distance.HECTOMETERS, Distance.MILLIMETERS,100000),
			new Convertion(Distance.HECTOMETERS, Distance.DECIMETERS,10000 ),
			new Convertion(Distance.HECTOMETERS, Distance.CENTIMETERS,1000 ),
			new Convertion(Distance.HECTOMETERS, Distance.METERS,100 ),
			new Convertion(Distance.HECTOMETERS, Distance.KILOMETERS,0.1 ),
			new Convertion(Distance.HECTOMETERS, Distance.INCHES,3937.01),
			new Convertion(Distance.HECTOMETERS, Distance.FOOT, 328.08416),
			new Convertion(Distance.HECTOMETERS, Distance.MILES, 0.0621371),
			new Convertion(Distance.KILOMETERS, Distance.MILLIMETERS, 1000000), 
			new Convertion(Distance.KILOMETERS, Distance.DECIMETERS, 10000 ), 
			new Convertion(Distance.KILOMETERS, Distance.CENTIMETERS,100000), 
			new Convertion(Distance.KILOMETERS, Distance.METERS, 1000), 
			new Convertion(Distance.KILOMETERS, Distance.HECTOMETERS, 10), 
			new Convertion(Distance.KILOMETERS, Distance.INCHES,39370.1),
			new Convertion(Distance.KILOMETERS, Distance.FOOT, 3280.841),
			new Convertion(Distance.KILOMETERS, Distance.MILES, 0.62137),
			new Convertion(Distance.INCHES, Distance.MILLIMETERS, 25.4000 ),
			new Convertion(Distance.INCHES, Distance.CENTIMETERS,2.54000 ),
			new Convertion(Distance.INCHES, Distance.DECIMETERS, 0.254 ),
			new Convertion(Distance.INCHES, Distance.METERS,0.0254 ),
			new Convertion(Distance.INCHES, Distance.HECTOMETERS,  0.000254 ),
			new Convertion(Distance.INCHES, Distance.KILOMETERS, 0.0000254),
			new Convertion(Distance.INCHES, Distance.FOOT,0.0833333 ),
			new Convertion(Distance.INCHES, Distance.MILES, 0.0000157 ),
			new Convertion(Distance.FOOT, Distance.MILLIMETERS, 304.8),
			new Convertion(Distance.FOOT, Distance.DECIMETERS,3.048 ),
			new Convertion(Distance.FOOT, Distance.CENTIMETERS,30.479 ),
			new Convertion(Distance.FOOT, Distance.METERS, 0.3048),
			new Convertion(Distance.FOOT, Distance.HECTOMETERS, 0.003048),
			new Convertion(Distance.FOOT, Distance.KILOMETERS, 0.0003048),
			new Convertion(Distance.FOOT, Distance.INCHES,12 ),
			new Convertion(Distance.FOOT, Distance.MILES, 0.000189394),
			new Convertion(Distance.MILES, Distance.MILLIMETERS, 1609344),
			new Convertion(Distance.MILES, Distance.CENTIMETERS, 160934.4 ),
			new Convertion(Distance.MILES, Distance.DECIMETERS, 16093.4 ),
			new Convertion(Distance.MILES, Distance.METERS, 1609 ),
			new Convertion(Distance.MILES, Distance.HECTOMETERS, 16.093 ),
			new Convertion(Distance.MILES, Distance.KILOMETERS,1.609 ),
			new Convertion(Distance.MILES, Distance.INCHES, 63359.84),
			new Convertion(Distance.MILES, Distance.FOOT, 5279.98),
		};

		
		public Distance convert(Distance distance, String toFormat) throws UnknownDistanceFormatException{
			if(distance.getFormatName().equals(toFormat)){
				return distance;
			}
			Convertion convertion = null;
			for(Convertion c : CONVERTIONS){
				if(c.fromFormat.equals(distance.getFormatName()) && c.toFormat.equals(toFormat)){
					convertion = c;
					break;
				}
			}
			if(convertion==null){
				throw new UnknownDistanceFormatException("No rate found for "+distance.getFormatName()+" - "+toFormat);
			}
			return new Distance(toFormat, distance.getValue()*convertion.rate);
		}
		
		private static class Convertion {
			double rate;
			String fromFormat;
			String toFormat;
			
			public Convertion(String fromFormat, String toFormat, double rate) {
				super();
				this.rate = rate;
				this.fromFormat = fromFormat;
				this.toFormat = toFormat;
			}
			
			
			
		}

}
