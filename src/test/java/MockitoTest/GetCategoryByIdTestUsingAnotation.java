package MockitoTest;


import mockito.com.entity.Category;
import mockito.com.repository.CategoryRepository;
import mockito.com.services.CategoryManagerImpl;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class GetCategoryByIdTestUsingAnotation {

	@Mock
	CategoryRepository categoryRepository;

	@InjectMocks
	CategoryManagerImpl categoryManagerImpl;

	
	@Test
	public void GetCategoryById() {
		MockitoAnnotations.initMocks(this);

		getData();
		Category expectedResult = new Category("1", "Samsung");

		Category actualResult = categoryManagerImpl.getCategoryById("10");
		
		Assert.assertEquals(expectedResult.getCatId(), actualResult.getCatId());
	}

	public void getData() {

		Mockito.when(categoryRepository.findOne(Mockito.anyString())).thenReturn(new Category("3", "Samsung"));
	}
}
