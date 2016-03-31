package ag.metierVDD;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPile {
	
	private Pile pile;
	private Pile pile2;

	@Before
	public void before() {
		pile = new Pile();
	}

	// @Test
	// public void testVide() {
	// int[] p = new int[6];
	// pile.setP(p);
	// pile.empiler(12);
	// boolean res = pile.estVide();
	// assertEquals(false, res);
	// }
	@Test
	public void testVide() {
		int monSp = -1;
		pile.setSp(monSp);
		assertTrue(pile.estVide());
		pile.setSp(0);
		assertFalse(pile.estVide());
		pile.setSp(10);
		assertFalse(pile.estVide());
	}

//	@Test
//	public void testPlein() {
//		pile = new Pile(10);
//		for (int i = 0; i < 10; i++) {
//			pile.empiler(i + 1);
//		}
//		boolean res = pile.estPleine();
//		assertEquals(true, res);
//	}
	@Test
	public void testPlein(){
		pile.setSp(9);
		assertTrue(pile.estPlein());
		pile.setSp(5);
		assertFalse(pile.estPlein());
	}

	@Test
	public void testDuracell() {
		int[] p = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		pile.setP(p);
		for (int i = 0; i < 11; i++) {
			pile.empiler(i + 1);
		}
		int[] p2 = pile.getP();
		boolean res = false;
		for (int i = 0; i < 10; i++) {
			if (p2[i] == p[i]) {
				res = true;
			} else {
				res = false;
				break;
			}
		}
		assertEquals(true, res);
	}

	@Test
	public void testVidange() {
		boolean res = false;
		int[] p = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < 11; i++) {
			pile.empiler(i + 1);
		}
		for (int i = 0; i < 11; i++) {
			pile.depiler();
		}
		int[] p2 = pile.getP();
		for (int i = 0; i < 10; i++) {
			if (p2[i] == p[i]) {
				res = true;
			} else {
				res = false;
				break;
			}
		}
		assertEquals(true, res);
	}

}
