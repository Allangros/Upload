package ag.main;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestPile {
	Pile pile;
	Pile pile2;

	@Before
	public void before() {
		pile = new Pile();
	}

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

	@Test
	public void testPlein() {
		pile.setSp(9);
		assertTrue(pile.estPleine());
		pile.setSp(5);
		assertFalse(pile.estPleine());
	}

	@Test
	public void testEmpiler() throws PilePleineException {
		int[] tab = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		pile.setP(tab);
		pile.setSp(-1);
		pile.empiler(50);
		int[] tabResultat = { 50, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertArrayEquals(tabResultat, pile.getP());
		assertEquals(0, pile.getSp());
	}

	@Test
	public void testDuracell() throws PilePleineException {
		pile = new Pile();
		int[] p = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

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
	public void testVidange() throws PilePleineException, PileVideException {
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
