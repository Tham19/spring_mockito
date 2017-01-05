package mockito.com.services;

import java.util.List;

import mockito.com.entity.Category;

public interface CategoryManager {
	public List<Category> getAllCategory();
	public Category getCategoryById(String catId);
}
