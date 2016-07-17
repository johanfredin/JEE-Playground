package se.fredin.playground.service;


import org.junit.Before;
import org.junit.Test;

public abstract class ServiceTest {
	
	@Before
	public abstract void setupMock();
	
	@Test
	public abstract void testCreate();
	
	@Test
	public abstract void testUpdate();
	
	@Test
	public abstract void testDelete();
	
	@Test
	public abstract void testFind();
	
	@Test
	public abstract void testGetAll();
	
}
