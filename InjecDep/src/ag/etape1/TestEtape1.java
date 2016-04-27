package ag.etape1;

import org.junit.Test;

import junit.framework.Assert;

public class TestEtape1 {

	@Test
	public void testA() {
		A a = new A();
		Assert.assertTrue(a.m());
	}

	@Test
	public void testB() {
		B b = new B();
		Assert.assertTrue(b.q());
	}

}
