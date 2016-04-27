package ag.etape5;

import org.junit.Test;

import ag.etape2.B2;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestEtape5 {

	@Test
	public void testA() {
		I i = new BtestOK();
		A a = new A(i);
		Assert.assertTrue(a.m());
		I j = new BtestNonOK();
		A a2 = new A(j);
		Assert.assertFalse(a2.m());
	}

	@Test
	public void testB() {
		B b = new B();
		Assert.assertTrue(b.q());
	}

	@Test
	public void testB2() {
		B2 b = new B2();
		Assert.assertTrue(b.q());
	}

	@Test
	public void testFactory() throws Exception {
		Factory factory = new Factory();
		Assert.assertTrue(factory.isBool());
	}
}
