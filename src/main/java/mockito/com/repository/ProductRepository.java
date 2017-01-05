package mockito.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mockito.com.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {	
}
