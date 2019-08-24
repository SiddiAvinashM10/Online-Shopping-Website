package com.siddi.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.siddi.shoppingbackend.dao.CategoryDAO;
import com.siddi.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home" , "/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		//passing category list
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping(value = "/listProducts")
	public ModelAndView showAllProducts()
	{
		//System.out.println("in all products");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		//passing category list
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/listProducts/{id}")
	public ModelAndView showIdProducts(@PathVariable("id") int id)
	{
		Category category = categoryDAO.get(id);
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", category.getName());
		//passing category list
		mv.addObject("categories", categoryDAO.list());
		//passing specific category
		mv.addObject("category", category);
		mv.addObject("userClickProduct", true);
		return mv;
	}
}
