package MockitoTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import mockito.com.entity.Product;
import mockito.com.repository.ProductRepository;
import mockito.com.services.ProductManagerImpl;

import org.junit.Assert;
import org.junit.Test;

public class GetAllProductByCatIdTestUsingMockObject {

	@Test
	public void test() {
		ProductRepository productRepository = mock(ProductRepository.class);
		List<Product> products = Arrays.asList(
				new Product("1", "Sam sung", "1"),
				new Product("2", "HTC", "2"),
				new Product("3", "Iphone", "2"),
				new Product("4", "BPhone", "4"));
		when(productRepository.findAll()).thenReturn(products);

		ProductManagerImpl productManagerImpl = new ProductManagerImpl(productRepository);

		List<Product> filter = productManagerImpl.getAllProductByCatId("2");

		Assert.assertEquals(2, filter.size());

	}
}
