package mockito.com.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import mockito.com.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
