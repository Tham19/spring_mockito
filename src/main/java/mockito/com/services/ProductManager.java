package mockito.com.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mockito.com.entity.Product;

public interface ProductManager{
	public List<Product> getAllProductByCatId(String catId);
	public List<Product> getAllProduct();
}
