package com.siddi.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.siddi.shoppingbackend.dao.ProductDAO;
import com.siddi.shoppingbackend.dto.Category;

public class ProductTestCase {

	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Category cat;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.siddi.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Products list check",
				5,productDAO.listActiveProducts().size());				
	} 
	
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Products list by cat 3 check",
				3,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Products list by cat 1 check",
				2,productDAO.listActiveProductsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Products list by count check",
				3,productDAO.getLatestActiveProducts(3).size());
		
	} 
}
