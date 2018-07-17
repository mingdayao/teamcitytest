package com.ymd.learn;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import junit.framework.Assert;
import test.IntegrationTests;

@Category(IntegrationTests.class)
public class FlowTest {
	
	@Test
	public void testNormalFlowOne() {
		Assert.assertEquals(true, true);
	}
}
