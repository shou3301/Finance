package org.cs.demoria.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.cs.demoria.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

	private ProductService productService;
	
	@RequestMapping(value="products", method=RequestMethod.GET)
	public String showProducts(Model model) {
		
		model.addAttribute("products", productService.getAllProducts());
		
		return "product/products";
	}

	public ProductService getProductService() {
		return productService;
	}

	@Resource(name="productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
}
