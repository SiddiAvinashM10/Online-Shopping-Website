package com.siddi.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.siddi.shoppingbackend.dao.CategoryDAO;
import com.siddi.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category cat;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.siddi.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testCRUD() {

		//ADD(CREATE)
		cat = new Category();
		cat.setName("Laptop");
		cat.setDescription("Laptop 1");
		cat.setImgURL("Laptop.png");
		assertEquals("successfully added a category inside the table!", true, categoryDAO.add(cat));

		cat = new Category();
		cat.setName("Television");
		cat.setDescription("Television 1");
		cat.setImgURL("Television.png");
		assertEquals("successfully added a category inside the table!", true, categoryDAO.add(cat));
		
		cat = new Category();
		cat.setName("Mobile");
		cat.setDescription("Mobile 1");
		cat.setImgURL("Mobile.png");
		assertEquals("successfully added a category inside the table!", true, categoryDAO.add(cat));
		
		//Get one(READ)
		cat = categoryDAO.get(2);
		assertEquals("successfully fetched a category inside the table!", "Television", cat.getName());
		
		//UPDATE
		cat = categoryDAO.get(1); cat.setImgURL("Laptop1.png");
		assertEquals("successfully fetched a category inside the table!", true, categoryDAO.update(cat));
		
		//DELETE
		 cat = categoryDAO.get(2);
		 assertEquals("successfully deleted a category inside the table!", true, categoryDAO.delete(cat));
		
		 //GET LIST(READ ALL)
		 assertEquals("successfully fetched the list of categories which are active inside the table!", 2, categoryDAO.list().size());
	}

}
