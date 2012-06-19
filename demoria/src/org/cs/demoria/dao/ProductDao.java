package org.cs.demoria.dao;

import java.util.List;

import org.cs.demoria.model.Product;

public interface ProductDao {

	public List<Product> findAllProducts();
	public Product findProductById(Integer id);
}
