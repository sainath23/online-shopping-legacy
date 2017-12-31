package com.doitgeek.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	private ModelAndView mv;
	/*
	 * Every request from /,/home and /index will be handled by index() method.
	 */
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping(value = "/listProducts")
	public ModelAndView listProducts() {
		mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickListProducts", true);
		return mv;
	}
}
