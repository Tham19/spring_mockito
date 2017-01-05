package MockitoTest;


import java.util.Arrays;
import java.util.List;

import mockito.com.entity.Product;
import mockito.com.repository.ProductRepository;
import mockito.com.services.ProductManagerImpl;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class GetAllProductTestUsingAnotation {
	@Mock
	ProductRepository productRepository;
	@InjectMocks
	ProductManagerImpl productManagerImpl;

	public List<Product> Setup() {
		List<Product> products = Arrays.asList(
				new Product("1", "Sam sung", "1"),
				new Product("2", "HTC", "2"),
				new Product("3", "Iphone", "3"),
				new Product("4", "BPhone", "4"));
		
		return products;
	}

	@Test
	public void test() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(productRepository.findAll()).then(new Answer<List<Product>>() {

			@Override
			public List<Product> answer(InvocationOnMock invocation) throws Throwable {
				return Setup();
			}
		});

		List<Product> products = productManagerImpl.getAllProduct();
		Assertions.assertThat(products).hasSize(4);		
	}
}
