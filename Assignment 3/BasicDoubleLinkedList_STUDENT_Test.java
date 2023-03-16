import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedList_STUDENT_Test
 {
	BasicDoubleLinkedList<String> lString;
	BasicDoubleLinkedList<Double> lDouble;
	BasicDoubleLinkedList<Car> lCar;
	StringComparator compS;
	DoubleComparator compD;
	CarComparator compCar;
	
	public Car a=new Car("Mercedes-Benz", "GClass", 2023);
	public Car b=new Car("Jeep", "Renegade", 2023);
	public Car c=new Car("Toyota", "Crown", 2023);
	public Car d=new Car("Honda", "Civic", 2023);
	public Car e=new Car("Chevrolet", "Silverado", 2023);
	public Car f=new Car("Chrysler ", "Pacifica Touring-L", 2023);

	public ArrayList<Car> fill = new ArrayList<Car>();
	

	@Before
	public void setUp() throws Exception {
		lString = new BasicDoubleLinkedList<String>();
		lString.addToEnd​("Say");
		lString.addToEnd​("Hi");
		compS = new StringComparator();
		
		lDouble = new BasicDoubleLinkedList<Double>();
		lDouble.addToEnd​(10.00);
		lDouble.addToEnd​(250.0);
		compD = new DoubleComparator();
		
		lCar= new BasicDoubleLinkedList<Car>();
		lCar.addToEnd​(d);
		lCar.addToEnd​(f);
		compCar = new CarComparator();
	}

	@After
	public void tearDown() throws Exception {
		lString = null;
		lDouble = null;
		lCar = null;
		compD = null;
		compS = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,lString.getSize());
		assertEquals(2,lDouble.getSize());
		assertEquals(2,lCar.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("Hi", lString.getLast());
		lString.addToEnd​("Finish");
		assertEquals("Finish", lString.getLast());
		
		assertEquals(f,lCar.getLast());
		lCar.addToEnd​(c);
		assertEquals(c,lCar.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Say", lString.getFirst());
		lString.addToFront​("Start");
		assertEquals("Start", lString.getFirst());
		
		assertEquals(d,lCar.getFirst());
		lCar.addToFront​(b);
		assertEquals(b,lCar.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Say", lString.getFirst());
		lString.addToFront​("Start");
		assertEquals("Start", lString.getFirst());
		
		assertEquals(d,lCar.getFirst());
		lCar.addToFront​(b);
		assertEquals(b,lCar.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("Hi", lString.getLast());
		lString.addToEnd​("Start");
		assertEquals("Start", lString.getLast());
		
		assertEquals(f,lCar.getLast());
		lCar.addToEnd​(c);
		assertEquals(c,lCar.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Car> list;
		lCar.addToFront​(c);
		lCar.addToEnd​(f);
		list = lCar.toArrayList();
		assertEquals(c,list.get(0));
		assertEquals(d,list.get(1));
		assertEquals(f,list.get(2));
		assertEquals(f,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		lString.addToFront​("Start");
		lString.addToEnd​("Finish");
		ListIterator<String> iterator = lString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Start", iterator.next());
		assertEquals("Say", iterator.next());
		assertEquals("Hi", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Finish", iterator.next());
		
		lCar.addToFront​(c);
		lCar.addToEnd​(f);
		ListIterator<Car> iteratorCar = lCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(f, iteratorCar.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		lCar.addToFront​(a);
		lCar.addToEnd​(d);
		ListIterator<Car> iteratorCar = lCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(f, iteratorCar.previous());
		assertEquals(d, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
	}
	 
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		lCar.addToFront​(b);
		lCar.addToEnd​(e);
		ListIterator<Car> iteratorCar = lCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(b, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(e, iteratorCar.next());
		
		try{
			//no more elements in list
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		lCar.addToFront​(b);
		lCar.addToEnd​(f);
		ListIterator<Car> iteratorCar = lCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(b, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(f, iteratorCar.previous());
		assertEquals(f, iteratorCar.previous());
		assertEquals(d, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		
		try{
			//no more elements in list
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		lCar.addToFront​(b);
		lCar.addToEnd​(e);
		ListIterator<Car> iteratorCar = lCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(b, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(e, iteratorCar.next());
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(d, lCar.getFirst());
		assertEquals(f, lCar.getLast());
		lCar.addToFront​(a);
		assertEquals(a, lCar.getFirst());
		lCar.remove(a, compCar);
		assertEquals(d, lCar.getFirst());
		//remove from the end of the list
		lCar.addToEnd​(c);
		assertEquals(c, lCar.getLast());
		lCar.remove(c, compCar);
		assertEquals(f, lCar.getLast());
		//remove from middle of list
		lCar.addToFront​(b);
		assertEquals(b, lCar.getFirst());
		assertEquals(f, lCar.getLast());
		lCar.remove(b, compCar);
		assertEquals(d, lCar.getFirst());
		assertEquals(f, lCar.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(d, lCar.getFirst());
		lCar.addToFront​(a);
		assertEquals(a, lCar.getFirst());
		assertEquals(a, lCar.retrieveFirstElement());
		assertEquals(d,lCar.getFirst());
		assertEquals(d, lCar.retrieveFirstElement());
		assertEquals(f,lCar.getFirst());
		
		assertEquals("Say", lString.getFirst());
		lString.addToFront​("Start");
		assertEquals("Start", lString.getFirst());
		assertEquals("Start", lString.retrieveFirstElement());
		assertEquals("Say",lString.getFirst());
		assertEquals("Say", lString.retrieveFirstElement());
		assertEquals("Hi",lString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(f, lCar.getLast());
		lCar.addToEnd​(c);
		assertEquals(c, lCar.getLast());
		assertEquals(c, lCar.retrieveLastElement());
		assertEquals(f,lCar.getLast());
		
		assertEquals("Hi", lString.getLast());
		lString.addToEnd​("Start");
		assertEquals("Start", lString.getLast());
		assertEquals("Start", lString.retrieveLastElement());
		assertEquals("Hi",lString.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String stat0, String stat1) {
			// TODO Auto-generated method stub
			return stat0.compareTo(stat1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double stat0, Double stat1) {
			// TODO Auto-generated method stub
			return stat0.compareTo(stat1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Car{
		String car_make;
		String car_model;
		int car_y;
		
		public Car(String make, String model, int year){
			this.car_make = make;
			this.car_model = model;
			this.car_y = year;
		}
		
		public String getMake(){
			return car_make;
		}
		public String getModel(){
			return car_model;
		}
		public int getYear(){
			return car_y;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}
