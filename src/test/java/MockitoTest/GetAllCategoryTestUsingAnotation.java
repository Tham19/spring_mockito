package MockitoTest;


import java.util.ArrayList;
import java.util.List;

import mockito.com.entity.Category;
import mockito.com.entity.Product;
import mockito.com.repository.CategoryRepository;
import mockito.com.repository.ProductRepository;
import mockito.com.services.CategoryManagerImpl;
import mockito.com.services.ProductManagerImpl;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class GetAllCategoryTestUsingAnotation {

	@Mock
	CategoryRepository categoryRepository;

	@InjectMocks
	CategoryManagerImpl categoryManagerImpl;

	@Test
	public void GetAllCategory() {
		MockitoAnnotations.initMocks(this);
		
		getData();
		int expectedResult = 4;

		List<Category> actualResult = categoryManagerImpl.getAllCategory();
		Assertions.assertThat(actualResult).hasSize(expectedResult);
	}

	public void getData() {

		Mockito.when(categoryRepository.findAll()).thenAnswer(new Answer<List<Category>>() {

					@Override
					public List<Category> answer(InvocationOnMock invocation)
							throws Throwable {
						List<Category> categories = new ArrayList<Category>();
						categories.add(new Category("1", "Sam sung"));
						categories.add(new Category("2", "HTC"));
						categories.add(new Category("3", "Iphone"));
						categories.add(new Category("4", "BPhone"));
						System.out.println("------" + categories.size());
						return categories;
					}
				});
	}
}
