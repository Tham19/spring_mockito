package mockito.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mockito.com.entity.Category;
import mockito.com.repository.CategoryRepository;

@Service
public class CategoryManagerImpl implements CategoryManager {

	@Autowired
	CategoryRepository categoryRepositor;

	@Override
	public List<Category> getAllCategory() {
		List<Category> categories;
		categories = categoryRepositor.findAll();

		return categories;
	}

	@Override
	public Category getCategoryById(String catId) {
		Category category = null;
		category = categoryRepositor.findOne(catId);
		
		return category ;
	}
}
