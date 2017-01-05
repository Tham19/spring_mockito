package MockitoTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import mockito.com.entity.Category;
import mockito.com.repository.CategoryRepository;
import mockito.com.services.CategoryManagerImpl;

@RunWith(Parameterized.class)
public class ParameterizeTestMockito {

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryManagerImpl categoryManagerImpl;

	private String input;

	private Category expected;

	public ParameterizeTestMockito(String input, Category expected) {
		this.input = input;
		this.expected = expected;
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Parameters
	public static List<Object[]> testCodition() {

		return Arrays.asList(new Object[][] {
			{ "1", new Category("1", "Sam sung") },
			{ "2", new Category("2", "IPhone") },
			{ "3", new Category("3", "HTC") },
			{ "4", new Category("4", "Blackbary") },
			});
	}

	@Test
	public void getCategoryById() {
		getData();
		Category category = categoryManagerImpl.getCategoryById(input);		
		assertThat(category, is(equalTo(expected)));
		verify(categoryRepository).findOne(input);		
		verifyNoMoreInteractions(categoryRepository);		
	}

	private void getData() {
		Mockito.when(categoryRepository.findOne(input)).thenReturn(expected);
	}
}
