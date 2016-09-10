package unitTests;

public class MetricDistanceExpressionParser {
	
	private static final String MINUS = "-";
	private static final String PLUS = "\\+";

	public Distance [] parse(String expression) throws UnknownDistanceFormatException{
		// count the operands
		int operandCount = countSubStringOccurrences(expression, PLUS)+countSubStringOccurrences(expression, MINUS)+1;
		if(expression.startsWith("-")){
			operandCount--;
		}
		Distance distance[] = new Distance[operandCount];
		int index = 0;
		expression = expression.trim().replaceAll(" ", "").replaceAll("\t", "").replaceAll("\n", ""); // loose the whitespaces 
		while(expression.length()>0){
			int sign = 1;
			if(expression.startsWith(MINUS)){
				expression = expression.replaceFirst(MINUS, "");
				sign = -1;
			} else if (expression.startsWith("+")){
				expression = expression.replaceFirst(PLUS, "");
			}
			int nextOpPos = nextOperatorPos(expression);
			String operand = null;
			if(nextOpPos==-1){// last operand
				operand = expression;
			} else {
				operand = expression.substring(0, nextOpPos);
			}
			expression = expression.replaceFirst(operand, "");
			distance[index++] = convertToDistance(operand, sign);
		}
		return distance;
	}
	
	public int nextOperatorPos(String expression) {
		int plusPos = expression.indexOf("+");
		int minusPos = expression.indexOf("-");
		if(plusPos==-1){
			return minusPos;
		}
		if(minusPos==-1){
			return plusPos;
		}
		return plusPos<minusPos?plusPos:minusPos;
	}

	private Distance convertToDistance(String e, int sign) throws UnknownDistanceFormatException {
		
		if(e.endsWith(Distance.MILLIMETERS)){
			return convertToDistance(e, sign, Distance.MILLIMETERS);
		} else if (e.endsWith(Distance.DECIMETERS)){
			return convertToDistance(e, sign, Distance.DECIMETERS);
		} else if (e.endsWith(Distance.CENTIMETERS)){
			return convertToDistance(e, sign, Distance.CENTIMETERS);
		}else if (e.endsWith(Distance.KILOMETERS)){
			return convertToDistance(e, sign, Distance.KILOMETERS); 
		} else if (e.endsWith(Distance.HECTOMETERS)){
			return convertToDistance(e, sign, Distance.HECTOMETERS);
		} else if (e.endsWith(Distance.INCHES)){
			return convertToDistance(e, sign, Distance.INCHES);
		} else if (e.endsWith(Distance.FOOT)){
			return convertToDistance(e, sign, Distance.FOOT);
		} else if (e.endsWith(Distance.MILES)) {
			return convertToDistance(e, sign, Distance.MILES);
		}else if (e.endsWith(Distance.METERS)){
			return convertToDistance(e, sign, Distance.METERS);
		}
		throw new UnknownDistanceFormatException("Can not parse [" + e + "] as a valid distance.");
	}
	
	private Distance convertToDistance(String e, int sign, String distanceFormat){
		return new Distance (distanceFormat, sign * Integer.parseInt(e.replace(distanceFormat, "")));
	}

	private int countSubStringOccurrences(String s, String sub){
		return s.length() - s.replaceAll(sub, "").length();
	}

}
