package org.cs.demoria.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.cs.demoria.dao.ProductDao;
import org.cs.demoria.model.Product;
import org.cs.demoria.service.ProductService;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	
	@Override
	public List<Product> getAllProducts() {
		return productDao.findAllProducts();
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	@Resource(name="productDao")
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Product findProductById(Integer pid) {
		return productDao.findProductById(pid);
	}

}
