package MockitoTest;

import java.util.ArrayList;
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

public class GetAllProductByCatIdTestUsingAnotation {

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductManagerImpl productManagerImpl;

	@Test
	public void GetAllProductByCatId() {
		MockitoAnnotations.initMocks(this);

		getData();
		int expectedResult = 2;

		List<Product> actualResult = productManagerImpl.getAllProductByCatId("2");
		Assertions.assertThat(actualResult).hasSize(expectedResult);
	}

	public void getData() {

		Mockito.when(productRepository.findAll()).thenAnswer(new Answer<List<Product>>() {

			@Override
			public List<Product> answer(InvocationOnMock invocation) throws Throwable {
				List<Product> products = new ArrayList<Product>();
				products.add(new Product("1", "Sam sung", "1"));
				products.add(new Product("2", "HTC", "2"));
				products.add(new Product("3", "Iphone", "2"));
				products.add(new Product("4", "BPhone", "4"));
				System.out.println("------" + products.size());
				return products;
			}
		});
	}
}
