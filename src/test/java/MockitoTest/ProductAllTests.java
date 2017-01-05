package MockitoTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GetAllProductByCatIdTestUsingAnotation.class, GetAllProductByCatIdTestUsingMockObject.class,
		GetAllProductTestUsingAnotation.class })
public class ProductAllTests {

}
