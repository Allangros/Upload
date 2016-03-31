package Codility;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestCodilityPassingCars {

	CodilityPassingCars codilityPassingCars;

	@Before
	public void before() {
		codilityPassingCars = new CodilityPassingCars();
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
		int[] a = { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };
		int reponse = codilityPassingCars.solution(a);
		assertEquals(21, reponse);
	}

	
	@Test
	public void single() {
		int[] a = { 0 };
		int reponse = codilityPassingCars.solution(a);
		assertEquals(0, reponse);
	}
	@Test
	public void simple(){
		int[] a={0,0,0,0,0};
		int reponse= codilityPassingCars.solution(a);
		assertEquals(0,reponse);
	}

	@Test
	public void extrem() {
		int[] a = new int[1000000];
		a[0] = 0;
		for (int i = 1; i < a.length; i++) {
			a[i] = 1;
		}
		int reponse = codilityPassingCars.solution(a);
		assertEquals(999999, reponse);
	}
@Test 
public void random(){
	int[]a = new int[100];
	for (int i = 0; i < a.length; i++) {
		a[i]=1;
	}
	for (int i = 1; i <10 ; i++) {
		int val=(int) Math.random()*a.length;
		a[val]=0;
	}
	int reponse=codilityPassingCars.solution(a);
	int reponse1=codilityPassingCars.solution2(a);
	assertEquals(reponse1,reponse);
}
@Test
public void depasse(){
	int[]a=new int[100000000];
	for (int i = 0; i < a.length; i++) {
		a[i]=1;
	}
	a[0]=0;
	a[15565665]=0;
	a[49000000]=0;
	a[18000000]=0;	a[35000000]=0;	a[7000000]=0;
	a[8000000]=0;
	a[9000000]=0;
	a[25000000]=0;
	a[70000000]=0;
	int reponse=codilityPassingCars.solution(a);
	int reponse2=codilityPassingCars.solution2(a);
	assertEquals(reponse, reponse2);
	System.out.println(reponse);
}
}
