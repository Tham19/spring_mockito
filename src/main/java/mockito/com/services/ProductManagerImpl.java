package mockito.com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mockito.com.entity.Product;
import mockito.com.repository.ProductRepository;

@Service
public class ProductManagerImpl implements ProductManager {

	@Autowired
	ProductRepository productRepository;

	public ProductManagerImpl() {
		super();
	}

	public ProductManagerImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public List<Product> getAllProductByCatId(String catId) {

		// C1: List<Product> products = productRepository.findAll();
		List<Product> products = getAllProduct();
		List<Product> filterProducts = new ArrayList<>();
		for (Product product : products) {
			if (product.getCatId().equalsIgnoreCase(catId))
				filterProducts.add(product);
		}
		return filterProducts;

	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> products = productRepository.findAll();
		return products;
	}
}
