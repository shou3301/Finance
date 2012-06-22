package org.cs.demoria.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.cs.demoria.model.Cash;
import org.cs.demoria.model.Loan;
import org.cs.demoria.model.ManagedFund;
import org.cs.demoria.model.Product;
import org.cs.demoria.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="product/{pid}", method=RequestMethod.GET)
	public String showProduct(@PathVariable("pid") Integer pid, Model model) {
		
		Product product = productService.findProductById(pid);
		model.addAttribute("product", product);
		
		if (product instanceof Cash) {
			return "product/cash";
		}
		else if (product instanceof Loan) {
			return "product/loan";
		}
		else if (product instanceof ManagedFund) {
			return "product/fund";
		}
		
		return null;
	}

	public ProductService getProductService() {
		return productService;
	}

	@Resource(name="productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
}
