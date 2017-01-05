package MockitoTest;

import java.util.Arrays;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import mockito.com.entity.Product;
import mockito.com.repository.ProductRepository;
import mockito.com.services.ProductManagerImpl;

public class GetAllProductTestWithException {
	
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductManagerImpl productManagerImpl;
	
	List<Product> expecteds;
	
	@Before
	public void setUp(){
		expecteds = Arrays.asList(
				new Product("1", "Sam sung", "1"),
				new Product("2", "Iphone", "2"),
				new Product("3", "Apple", "3"),
				new Product("4", "HTC", "4"));
	}

	@Test(expected = NullPointerException.class)
	public void test() {
		getData();
		MockitoAnnotations.initMocks(this);
		List<Product> actuals = productManagerImpl.getAllProduct();
		
		Assertions.assertThat(expecteds).hasSize(actuals.size());		
	}

	private void getData() {
		Mockito.when(productRepository.findAll()).thenReturn(null);			
	}

}
