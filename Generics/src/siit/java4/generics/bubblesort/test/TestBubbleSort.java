package siit.java4.generics.bubblesort.test;

import static org.junit.Assert.*;
import java.util.EmptyStackException;
import org.junit.Test;
import siit.java4.generics.bubblesort.BubbleSort;
import siit.java4.generics.bubblesort.Student;

public class TestBubbleSort {

	private String[] sArr;
	
	//A JUnit test for String
	@Test
	public void testString() {
		
		 sArr = new String[]{"Carl","Bob","Diana","Alice","Frank","Adam"};
		 String[] sExp = new String[]{"Adam","Alice","Bob","Carl","Diana","Frank"};
		 
		 BubbleSort.bubbleSort(sArr);
		 
		 assertArrayEquals(sArr, sExp);
	}

	// test for Integer
	@Test
	public void testInteger() {
		
		Integer[] actual = new Integer[]{-5,6,1,3,4,7,0,-17};
		Integer[] expected = new Integer[]{-17,-5,0,1,3,4,6,7};
		BubbleSort.bubbleSort(actual);	
			
		assertArrayEquals(expected, actual);
	}
	
	//test for Double
	@Test 
	public void testDouble() {
		
		Double[] actual = new Double[]{-2.5,-2.6,-2.7,-2.0,5.1,5.2,5.21,3.1};
		Double[] expected = new Double[]{-2.7,-2.6,-2.5,-2.0,3.1,5.1,5.2,5.21};
		BubbleSort.bubbleSort(actual);
		
		assertArrayEquals(expected, actual);
		
	}
	
	//test for object
	@Test
	public void testObject(){
		Student[] actual = new Student[4];
		actual[0] = new Student("John Doe", "Chicago", 52, "113");
		actual[1] = new Student("David Hasselhoff", "Paris", 5, "N22");
		actual[2] = new Student("Elisabeth Taylor", "London", 332, "XE32");
		actual[3] = new Student("Dan Matthew", "Rome", 11, "Z1");
		
		Student[] expected = new Student[4];
		expected[0] = new Student("John Doe", "Chicago", 52, "113");
		expected[1] = new Student("David Hasselhoff", "Paris", 5, "N22");
		expected[2] = new Student("Elisabeth Taylor", "London", 332, "XE32");
		expected[3] = new Student("Dan Matthew", "Rome", 11, "Z1");
		
		assertArrayEquals(expected, actual);
	}
	

	//test the empty stack exception
	@Test(expected = EmptyStackException.class)
	public void isEmptyException(){
				Integer[] actual = new Integer[]{};
				BubbleSort.bubbleSort(actual);	
	}
}